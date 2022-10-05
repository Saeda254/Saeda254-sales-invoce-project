
package controller;


import VIEW.InvoiceFrame;
import model.ShowLineTabel;
import model.sigHeader;
import model.sigItem;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.util.ArrayList;

/**
 *
 * @author SAEDA
 */
public class TableAction implements ListSelectionListener{
    private InvoiceFrame frame;

    public TableAction(InvoiceFrame frame) {
        this.frame = frame;
    }
    
/*when select an invoice from the header tabel this method finds out which invoice has been selected
    from the header tabel and gets its item lines and update the second table the item table
    */
    @Override
    public void valueChanged(ListSelectionEvent e) {
        int invoiceIndex = frame.getTableInvoiceHeader().getSelectedRow();
        if(invoiceIndex!= -1){
             sigHeader selectedRow = frame.getInvoices().get(invoiceIndex);
             ArrayList<sigItem> items = selectedRow.getItems();
             frame.getLabelCustomerName().setText(selectedRow.getName());
             frame.getLabelInvoiceNum().setText(""+selectedRow.getNum());
             frame.getLabelInvoiceDate().setText(selectedRow.getDate());
             frame.getLabelTostalCost().setText(""+selectedRow.getTotalInvoice());
             ShowLineTabel line = new ShowLineTabel(items);
             frame.getTableInvoiceLines().setModel(line);
             line.fireTableDataChanged();
             
        }
    }
    
}
