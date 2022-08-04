package lesson1.invoice;

import Lesson1.invoice.Invoice;
import Lesson1.invoice.InvoiceItem;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class InvoiceTest {
    @Test
    public void checkSumm (){
        InvoiceItem[] i = new InvoiceItem[]{
        new InvoiceItem("abc123", "Гвозди отбойные", 12, 0.02),
        new InvoiceItem("cbd123", "Молоток", 1, 4.5),
        new InvoiceItem("cee123", "Изолента синяя", 3, 0.5)
        };
        Invoice invoice = new Invoice(i);
        assertEquals(
                6.24,
                invoice.calculate(),
                0.000001);
        ;
    }
}
