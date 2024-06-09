package com.juaracoding.rujian2ut.ujian2;
import java.util.Scanner;
import java.util.Locale;
import java.text.NumberFormat;

public class ATM {
    private double saldo;
    private NumberFormat currencyFormat;

    // Konstruktor untuk inisialisasi saldo awal
    public ATM(double saldoAwal) {
        this.saldo = saldoAwal;
        this.currencyFormat = NumberFormat.getCurrencyInstance(new Locale("id", "ID"));
    }

    // Metod untuk mengembalikan saldo
    public double getSaldo() {
        return saldo;
    }

    public String lihatSaldo() {
        return currencyFormat.format(saldo);
    }

    // Metod untuk setor uang
    public void setorUang(double jumlah) {
        if (jumlah > 0) {
            saldo += jumlah;
            System.out.println("Setoran berhasil. Jumlah yang disetor: " + currencyFormat.format(jumlah));
        } else {
            throw new IllegalArgumentException("Jumlah setoran harus lebih dari nol.");
        }
    }

    // Metod untuk tarik uang
    public void tarikUang(double jumlah) {
        if (jumlah > 0 && jumlah <= saldo) {
            saldo -= jumlah;
            System.out.println("Penarikan berhasil. Jumlah yang ditarik: " + currencyFormat.format(jumlah));
        } else {
            throw new IllegalArgumentException("Jumlah penarikan tidak valid atau saldo tidak mencukupi.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Berfungsi ketika di run input  saldo awal
        System.out.print("Masukkan saldo awal: ");
        double saldoAwal = scanner.nextDouble();

        ATM atm = new ATM(saldoAwal);

        while (true) {
            System.out.println("*** ATM  ***");
            System.out.println("1. Cek Saldo");
            System.out.println("2. Tarik Uang");
            System.out.println("3. Setor Uang");
            System.out.println("4. Keluar");
            System.out.print("Pilih opsi: ");
            int pilihan = scanner.nextInt();

            try {
                switch (pilihan) {
                    case 1:
                        System.out.println("Saldo Anda: " + atm.lihatSaldo());
                        break;
                    case 2:
                        System.out.print("Masukkan jumlah yang akan ditarik: ");
                        double jumlahTarik = scanner.nextDouble();
                        atm.tarikUang(jumlahTarik);
                        break;
                    case 3:
                        System.out.print("Masukkan jumlah yang akan disetor: ");
                        double jumlahSetor = scanner.nextDouble();
                        atm.setorUang(jumlahSetor);
                        break;
                    case 4:
                        System.out.println("Terima kasih telah menggunakan ATM!");
                        scanner.close();
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Silakan pilih opsi yang benar.");
                        break;
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Notifikasi: " + e.getMessage());
            }

            System.out.println();
        }
    }
}
