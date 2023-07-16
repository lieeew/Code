#include <stdlib.h>
#include <stdio.h>

int findByElement(int arr[], int size, int key)
{
    for (int i = 0; i < size; i++)
    {
        if (arr[i] == key)
        {
            return i;
        }
    }
    return -1;
}

int addByElementSequence(int arr[], int size, int element)
{
    if (size >= sizeof(arr) / sizeof(arr[0]))
    {
        return -1;

        int index = size;
        for (int i = 0; i < size; i++)
        {
            if (element < arr[i])
            {
                index = i;
                break;
            }
        }
        for (int j = size; j > index; j--)
        {
            arr[j] = arr[j - 1];
        }

        arr[index] = element;

        return index;
    }
}

    int main()
    {

        int a[] = {1, 2, 2, 1, 5, 2, 4, 0, 0, 0};

        int index = findByElement(a, 7, 5);
        int index = addByElementSequence(a, 2, 7);

        return 0;
    }