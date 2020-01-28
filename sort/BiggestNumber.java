class BiggestNumber {
  static int partition(int arr[], int low, int high) {
    int pivot = arr[high];
    int i = (low - 1);
    for (int j = low; j < high; j++) {
      StringBuilder sb = new StringBuilder();
      StringBuilder sb2 = new StringBuilder();
      sb.append(arr[j]);
      sb.append(pivot);      
      sb2.append(pivot);
      sb2.append(arr[j]);
      
      if (Integer.parseInt(sb.toString()) > Integer.parseInt(sb2.toString())) {
        i++;
        
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
      }
    }
    
    int temp = arr[i + 1];
    arr[i + 1] = arr[high];
    arr[high] = temp;
    
    return i + 1;
  }
  
  static void sort(int arr[], int low, int high) {
    if (low < high) {
      int pi = partition(arr, low, high);
      
      sort(arr, low, pi - 1);
      sort(arr, pi + 1, high);
    } 
  }
  
  public String solution(int[] numbers) {
    String answer = "";
    StringBuilder sb = new StringBuilder();
    
    sort(numbers, 0, numbers.length - 1);
    
    if (numbers[0] == 0) {
      return "0";
    }
    
    for (int a : numbers) {
      sb.append(a);
    }
    
    answer = sb.toString();
    return answer;
  }
}
