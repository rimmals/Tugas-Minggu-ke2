import com.juaracoding.rujian2ut.ujian2.ATM;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.text.NumberFormat;
import java.util.Locale;


public class ATMTest {
    private ATM atm;
    private NumberFormat currencyFormat;

    @BeforeMethod
    public void setUp() {
            atm = new ATM(1000);
            currencyFormat = NumberFormat.getCurrencyInstance(new Locale("id", "ID"));
    }
    @Test
    public void testLihatSaldo() {
        double actualSaldo = atm.getSaldo();
        double expectedSaldo = 1000;
        Assert.assertEquals(actualSaldo, expectedSaldo, "Expected: " + expectedSaldo + ", Actual: " + actualSaldo);
        System.out.println("Saldo saat ini: " + atm.lihatSaldo());
    }
    @Test
    public void testSetorUang() {
        double jumlahSetor = 500;
        atm.setorUang(jumlahSetor);
        double actualSaldo = atm.getSaldo();
        double expectedSaldo = 1500;
        Assert.assertEquals(actualSaldo, expectedSaldo, "Expected: " + expectedSaldo + ", Actual: " + actualSaldo);
        System.out.println("Jumlah yang disetor: " + currencyFormat.format(jumlahSetor));
        System.out.println("Saldo setelah setoran: " + atm.lihatSaldo());
    }
    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testSetorUangNegatif() {
        atm.setorUang(-500);
    }

    @Test
    public void testTarikUang() {
        atm.tarikUang(-500);
        double actualSaldo = atm.getSaldo();
        double expectedSaldo = 500;
        Assert.assertEquals(actualSaldo, expectedSaldo, "Expected: " + expectedSaldo + ", Actual: " + actualSaldo);
        System.out.println("Saldo setelah penarikan: " + atm.lihatSaldo());
    }
    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testTarikUangLebihDariSaldo() {
        atm.tarikUang(500);
    }
    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testTarikUangNegatif() {
        atm.tarikUang(-100);
    }




}



