package LEVEL_1.lesson_2;

public class Check_HT_Vlad {
    public static void main(String[] args) {
        byte[] arr1 = {1,0,1,1,1,0,0,1,1,0,0,0,0,1};
        task1(arr1);
        task2();
        byte[] arr3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 24};
        task3(arr3);
        task4();
        byte[] arr5 = {1,5,78,6,16,0,15,4,2,36,-6};
        task5Max(arr5);
        task5Min(arr5);
        byte[] arr6 = {1, 2, 3, 2, 1, 3};
        System.out.println(task6(arr6));
        byte[] arr7 = {1,2,3,4,5,6};
        task7(arr7,(byte)2);
        task7(arr7,(byte) -1);
    }

    static void task1(byte[] arr){
        for (int i=0;i<arr.length;i++){
            if(arr[i]==1) arr[i]=0;
            else arr[i]=1;
        }
        PrintArr(arr);
    }

    static void task2(){
        byte[] arr2 = new byte[8];
        for (byte i=0;i<8;i++){
            arr2[i] = (byte) (i*3);
        }
        PrintArr(arr2);
    }


    static void task3(byte[] arr3){
        for (byte i=0;i<arr3.length;i++){
            if(arr3[i]<6) arr3[i]*=2;
        }
        PrintArr(arr3);
    }

    static void task4(){
        byte[][] arr4 = new byte[5][5];
        for (byte i=0;i<5;i++){
            for (byte j=0;j<5;j++){
                if(i==j) arr4[i][j]=1;
                System.out.print(arr4[i][j]+"\t");
            }
            System.out.println();
        }
        System.out.println("------------------");
    }

    static void task5Min(byte[] arr){
        byte max = 127;//Самое большое число этого типа данных :)
        for (byte i=0;i<arr.length;i++){
            if(arr[i]<max) max=arr[i];
        }
        System.out.println("Минимальный элемент: " + max);
    }

    static void task5Max(byte[] arr){
        byte min=-128;//Самое маленькое число этого типа данных :)
        for (byte i=0;i<arr.length;i++){
            if(arr[i]>min) min=arr[i];
        }
        System.out.println("Максимальный элемент: " + min);
    }

    static boolean task6(byte[] arr) {
        byte LeftS, RigthS;

        for (int i = 0; i < arr.length + 1; i++) {
            LeftS = 0;
            RigthS = 0;

            for (int j = 0; j < i; j++) {
                LeftS += arr[j];
            }

            for (int j = i; j < arr.length; j++) {
                RigthS += arr[j];
            }

            if (RigthS == LeftS) return true;
        }
        return false;
    }

    static void task7(byte[] arr,byte n){
        byte temp;
        if (n<0){
            for (byte j=0;j< -1 *n;j++){
                temp=arr[0];
                for (byte i=0;i<arr.length-1;i++)
                    arr[i]=arr[i+1];

                arr[arr.length-1]=temp;
            }

        }
        else {

            for (byte j = 1; j <= n; j++) {
                temp = arr[arr.length - 1];
                for (int i = arr.length - 1; i > 0; i--)
                    arr[i] = arr[i - 1];
                arr[0] = temp;
            }
        }

        PrintArr(arr);
    }

       static void PrintArr(byte[] arr){
        for (byte a: arr) {
            System.out.println(a);
        }
        System.out.println("------------------");
    }
}
