#include <stdio.h>

int main() {
    int n;

    printf("Enter the size of array: ");
    scanf("%d", &n);

    int arr[n]; // Variable-length array

    printf("Enter %d elements:\n", n);
    for(int i = 0; i < n; i++) {
        printf("Element %d: ", i + 1);
        scanf("%d", &arr[i]);
    }

    printf("\nIndices where element value is less than 35:\n");
    for(int i = 0; i < n; i++) {
        if (arr[i] < 35) {
            printf("%d ", i);
        }
    }

    return 0;
}
