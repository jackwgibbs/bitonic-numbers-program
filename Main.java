public class Main{
    public static void main(String[] args){
        BitonicNumbers alorithm = new BitonicNumbers();

        int[] numbers = {1,2,3,4,3,1,8,6,4,3,6,8,9,6,4,3,1,2};

        int[] bitonicNumbers = alorithm.runAlgorithm(numbers);

        // Display the bitonic array
        if (bitonicNumbers[0] == -1){
            System.out.println("No bitonic array found");
        }else{
            System.out.println("The greatest bitonic array is:");
            for (int i=0; i<bitonicNumbers.length-1; i++){
                System.out.print(bitonicNumbers[i] + ", ");
            }
            System.out.println(bitonicNumbers[bitonicNumbers.length -1 ]);
        }
    }
}