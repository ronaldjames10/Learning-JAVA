document.addEventListener('DOMContentLoaded', () => {
    const calendarGrid = document.querySelector('.calendar-grid');
    const selectedDateDisplay = document.getElementById('selected-date-display');
    const reminderList = document.getElementById('reminder-list');
    const addReminderForm = document.getElementById('add-reminder-form');
    const reminderInput = document.getElementById('reminder-input');
    const addReminderBtn = document.getElementById('add-reminder-btn');
    const viewAllBtn = document.getElementById('view-all-btn');

    let selectedDate = null;

    // --- Event Listeners ---

    calendarGrid.addEventListener('click', (event) => {
        const dayCell = event.target.closest('.day-cell');
        if (dayCell && !dayCell.classList.contains('empty')) {
            handleDayClick(dayCell);
        }
    });

    viewAllBtn.addEventListener('click', fetchAllReminders);

    addReminderBtn.addEventListener('click', () => {
        const text = reminderInput.value.trim();
        if (text && selectedDate) {
            addReminder(selectedDate, text);
        }
    });

    // Make sure 'Enter' key works for adding reminders
    reminderInput.addEventListener('keypress', (event) => {
        if (event.key === 'Enter') {
            addReminderBtn.click();
        }
    });

    reminderList.addEventListener('click', (event) => {
        // IMPORTANT: Use .closest() to handle clicks on the icon inside the button
        const deleteButton = event.target.closest('.delete-btn');
        if (deleteButton) {
            const date = deleteButton.dataset.date;
            const text = deleteButton.dataset.text;
            if (confirm(`Are you sure you want to delete this reminder: "${text}"?`)) {
                deleteReminder(date, text);
            }
        }
    });

    // --- Functions ---

    function handleDayClick(dayCell) {
        const currentSelected = document.querySelector('.day-cell.selected');
        if (currentSelected) {
            currentSelected.classList.remove('selected');
        }
        dayCell.classList.add('selected');
        selectedDate = dayCell.dataset.date;
        selectedDateDisplay.textContent = new Date(selectedDate + 'T00:00:00').toLocaleDateString('en-US', {
            year: 'numeric', month: 'long', day: 'numeric'
        });
        fetchRemindersForDay(selectedDate);
        addReminderForm.classList.remove('hidden');
    }

    async function fetchRemindersForDay(date) {
        const response = await fetch(`/api/reminders?date=${date}`);
        const reminders = await response.json();
        renderSingleDayReminders(reminders, date);
    }
    
    async function fetchAllReminders() {
        const currentSelected = document.querySelector('.day-cell.selected');
        if (currentSelected) {
            currentSelected.classList.remove('selected');
        }
        selectedDate = null;
        addReminderForm.classList.add('hidden');
        selectedDateDisplay.textContent = "All Saved Reminders";

        const response = await fetch('/api/reminders/all');
        const allReminders = await response.json();
        renderAllReminders(allReminders);
    }

    function renderSingleDayReminders(reminders, date) {
        reminderList.innerHTML = '';
        if (reminders.length === 0) {
            const p = document.createElement('p');
            p.textContent = 'No reminders for this day.';
            reminderList.appendChild(p);
            return;
        }
        reminders.forEach(text => {
            const item = createReminderElement(date, text);
            reminderList.appendChild(item);
        });
    }

    function renderAllReminders(allReminders) {
        reminderList.innerHTML = '';
        const sortedDates = Object.keys(allReminders).sort();

        if (sortedDates.length === 0) {
            const p = document.createElement('p');
            p.textContent = 'You have no reminders saved.';
            reminderList.appendChild(p);
            return;
        }

        sortedDates.forEach(date => {
            const dateHeader = document.createElement('h4');
            dateHeader.className = 'reminder-date-header';
            dateHeader.textContent = new Date(date + 'T00:00:00').toLocaleDateString('en-US', {
                weekday: 'long', year: 'numeric', month: 'long', day: 'numeric'
            });
            reminderList.appendChild(dateHeader);

            allReminders[date].forEach(text => {
                const item = createReminderElement(date, text);
                reminderList.appendChild(item);
            });
        });
    }

    function createReminderElement(date, text) {
        const item = document.createElement('div');
        item.className = 'reminder-item';
        const textSpan = document.createElement('span');
        textSpan.textContent = text;
        
        const deleteButton = document.createElement('button');
        deleteButton.className = 'delete-btn';
        deleteButton.dataset.date = date;
        deleteButton.dataset.text = text;
        deleteButton.innerHTML = '<i class="fas fa-trash-alt"></i>';

        item.appendChild(textSpan);
        item.appendChild(deleteButton);
        return item;
    }

    async function addReminder(date, text) {
        await fetch('/api/reminders/add', {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify({ date, text })
        });
        reminderInput.value = '';
        fetchRemindersForDay(date);
        document.querySelector(`[data-date="${date}"]`).classList.add('has-reminder');
    }

    async function deleteReminder(date, text) {
        await fetch('/api/reminders/delete', {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify({ date, text })
        });

        if (selectedDate) {
            fetchRemindersForDay(selectedDate);
        } else {
            fetchAllReminders();
        }

        const remaining = await (await fetch(`/api/reminders?date=${date}`)).json();
        if (remaining.length === 0) {
             const dayCell = document.querySelector(`[data-date="${date}"]`);
             if (dayCell) {
                dayCell.classList.remove('has-reminder');
             }
        }
    }
});