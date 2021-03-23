package it.beije.ananke.reservation.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.beije.ananke.reservation.model.Invoice;
import it.beije.ananke.reservation.repository.InvoiceRepository;

@Service
public class InvoiceService {

	@Autowired
	private InvoiceRepository invoiceRepository;
	
	public Invoice getInvoiceById(Integer id) {
		return invoiceRepository.findByInvoiceId(id);
	}
	
	public List<Invoice> getAllInvoices(){
		return invoiceRepository.findAll();
	}
	
	public void removeInvoice(Integer id) {
		invoiceRepository.deleteById(id);
	}
	public void insertInvoice(Invoice invoice) {
		invoiceRepository.save(invoice);
	}
}
