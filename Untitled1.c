#include <stdio.h>

void swap(int *a, int *b) {
    int t = *a;
    *a = *b;
    *b = t;
}

int main() {
    int n, i, j;

    printf("Enter number of processes: ");
    scanf("%d", &n);

    int pid[n], bt[n], priority[n], wt[n], tat[n];

    for (i = 0; i < n; i++) {
        pid[i] = i + 1;
        printf("Enter burst time and priority for process %d: ", i + 1);
        scanf("%d%d", &bt[i], &priority[i]);
    }

    for (i = 0; i < n - 1; i++) {
        for (j = i + 1; j < n; j++) {
            if (priority[i] > priority[j]) {
                swap(&priority[i], &priority[j]);
                swap(&bt[i], &bt[j]);
                swap(&pid[i], &pid[j]);
            }
        }
    }

    wt[0] = 0;
    for (i = 1; i < n; i++) {
        wt[i] = wt[i - 1] + bt[i - 1];
    }

    for (i = 0; i < n; i++) {
        tat[i] = wt[i] + bt[i];
    }

    printf("\nProcess\tPriority\tBT\tWT\tTAT\n");
    for (i = 0; i < n; i++) {
        printf("%d\t%d\t\t%d\t%d\t%d\n", pid[i], priority[i], bt[i], wt[i], tat[i]);
    }

    return 0;
}
