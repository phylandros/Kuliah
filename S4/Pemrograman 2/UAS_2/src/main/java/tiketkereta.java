import java.util.*;

public class tiketpesawat {

    public static void main(String[] args) {

        String nama_kereta[], nama_penumpang[], kelas_kereta[],no_ktp[],juml_tiket[];
        String jawab;
        System.out.println("+++++++++++++++++++++++++");
        System.out.println("|  TIKET KERETA API     |");
        System.out.println("+++++++++++++++++++++++++");
        System.out.println("|1. Input               |");
        System.out.println("|2. Update              |");
        System.out.println("|3. View                |");
        System.out.println("|4. Exit                |");
        System.out.println("+++++++++++++++++++++++++");
            Scanner input = new Scanner(System.in);
            System.out.print("Pilih ? :  ");
            String pilih = input.nextLine();
                switch (pilih) {
                    case "1":
                        Scanner input_insert = new Scanner(System.in);
                        Scanner input_insert2 = new Scanner(System.in);
                        System.out.println("Data yang ingin dimasukan ?");
                        int jml=input_insert.nextInt();
        
                        nama_kereta = new String[jml];
                        no_ktp = new String[jml];
                        nama_penumpang = new String[jml];
                        kelas_kereta = new String[jml];
                        juml_tiket = new String[jml];
                        byte no = 1;
        
                        for(int i = 0; i < no_ktp.length; i++){
                            System.out.println("Data Ke : " + no); 
                            System.out.print("Nama Kereta : ");
                            nama_kereta[i] = input_insert2.nextLine();
        
                            System.out.print("No. KTP : ");
                            no_ktp[i] = input_insert2.nextLine();
        
                            System.out.print("Nama Penumpang : ");
                            nama_penumpang[i] = input_insert2.nextLine();
        
                            System.out.print("Kelas Kereta : ");
                            kelas_kereta[i] = input_insert2.nextLine();
                            
                            System.out.print("Jumlah Tiket : ");
                            juml_tiket[i] = input_insert2.nextLine();
                            no++;
                        }
                    break;
                
                    default:
                    System.out.println("Salah Pilihan");
                        break;
                }
    }
}
