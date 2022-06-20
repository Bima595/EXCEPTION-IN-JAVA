package MODUL5;

import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Driver {
    static Scanner s = new Scanner(System.in);
    private static String alamat;
    private static int panjangTanah;
    private static int luasTanah;

    public void setAlamat(String alamat) {
        alamat = alamat;
    }


    public void setPanjangTanah() {
        panjangTanah = panjangTanah;
    }


    public void setLuasTanah() {
        luasTanah = luasTanah;
    }

    public static void menu() throws Exception {
        System.out.println("1. Read\n2. Create\n3.Exit");
        System.out.printf("pilih no : ");
        int menu = Integer.parseInt(s.nextLine());

        switch (menu) {
            case 1:
                tampil();
                menu();
            case 2:
                tulis();
                menu();
            case 3:
                System.exit(0);
        }

    }

    private static void tampil() throws Exception {
        FileReader fileInput;
        BufferedReader bufferInput;
        try {
            fileInput = new FileReader("file.txt");
            bufferInput = new BufferedReader(fileInput);
            System.out.printf("%-20s %-15s %-15s\n", "Alamat", "Panjang Tanah", "Luas tanah");

            String Line = "";
            String data = "";
            while ((Line = bufferInput.readLine()) != null) {
                StringTokenizer tokenizer = new StringTokenizer(Line, ",");
                String alamat = tokenizer.nextToken();
                String panjangTanah = tokenizer.nextToken();
                String luasTanah = tokenizer.nextToken();
                System.out.printf("%-20s %-15s %-15s\n", alamat, panjangTanah, luasTanah);
            }
            System.out.println(data);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println("data ini di lindungi oleh hak cipta !!!");
            menu();
        }
    }

    private static void tulis() throws Exception {
        try {

            FileWriter fileoutput = new FileWriter("file.txt", true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileoutput);
            System.out.printf("input Alamat : ");
            alamat = s.nextLine();
            System.out.printf("input Panjang tanah : ");
            panjangTanah = Integer.parseInt(s.nextLine());
            System.out.printf("input luas tanah : ");
            luasTanah = Integer.parseInt(s.nextLine());

            String tulis = String.format("%s,%s,%s\n", alamat, panjangTanah, luasTanah);

            bufferedWriter.write(tulis);

            bufferedWriter.close();
        }catch(InputMismatchException r) {
            System.err.println(r);
            System.out.println("");
        }finally {
            menu();
        }
    }

    public static void main(String[] args) throws Exception {
        menu();
    }
}