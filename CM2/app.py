from flask import Flask, render_template, request, jsonify
import json
import calendar
from datetime import datetime

app = Flask(__name__)

REMINDER_FILE = "reminders.json"

def load_reminders():
    """Loads reminders from the JSON file."""
    try:
        with open(REMINDER_FILE, 'r') as f:
            return json.load(f)
    except (FileNotFoundError, json.JSONDecodeError):
        return {}

def save_reminders(reminders):
    """Saves the reminders dictionary to the JSON file."""
    with open(REMINDER_FILE, 'w') as f:
        json.dump(reminders, f, indent=4, sort_keys=True)

@app.route('/')
def index():
    """Renders the main calendar page."""
    year = request.args.get('year', datetime.now().year, type=int)
    month = request.args.get('month', datetime.now().month, type=int)

    # Handle month/year wrapping
    if month < 1:
        month = 12
        year -= 1
    elif month > 12:
        month = 1
        year += 1
    
    # Create a dynamic range of years for the dropdown
    year_range = range(year - 100, year + 110)

    reminders = load_reminders()
    month_calendar = calendar.monthcalendar(year, month)
    
    # Prepare calendar data with reminder info
    calendar_data = []
    for week in month_calendar:
        week_data = []
        for day in week:
            if day == 0:
                week_data.append(None)
            else:
                date_key = f"{year}-{month:02d}-{day:02d}"
                week_data.append({
                    "day": day,
                    "has_reminder": date_key in reminders and reminders[date_key],
                    "is_today": date_key == datetime.now().strftime("%Y-%m-%d")
                })
        calendar_data.append(week_data)

    return render_template('index.html',
                           calendar_data=calendar_data,
                           month_name=calendar.month_name[month],
                           current_year=year,
                           current_month=month,
                           year_range=year_range, # Pass the year range to the template
                           calendar=calendar) # Pass the calendar module for month names

@app.route('/api/reminders', methods=['GET'])
def get_reminders():
    """Gets reminders for a single date."""
    date = request.args.get('date')
    reminders = load_reminders()
    return jsonify(reminders.get(date, []))

@app.route('/api/reminders/all', methods=['GET'])
def get_all_reminders():
    """Gets all saved reminders."""
    reminders = load_reminders()
    return jsonify(reminders)

@app.route('/api/reminders/add', methods=['POST'])
def add_reminder():
    """Adds a new reminder."""
    data = request.json
    date = data['date']
    text = data['text']
    
    reminders = load_reminders()
    if date not in reminders:
        reminders[date] = []
    reminders[date].append(text)
    save_reminders(reminders)
    
    return jsonify({"status": "success", "message": "Reminder added."})

@app.route('/api/reminders/delete', methods=['POST'])
def delete_reminder():
    """Deletes a specific reminder."""
    data = request.json
    date = data['date']
    text = data['text']
    
    reminders = load_reminders()
    if date in reminders and text in reminders[date]:
        reminders[date].remove(text)
        if not reminders[date]:
            del reminders[date]
        save_reminders(reminders)
        return jsonify({"status": "success", "message": "Reminder deleted."})
        
    return jsonify({"status": "error", "message": "Reminder not found."}), 404

if __name__ == '__main__':
    app.run(debug=True)