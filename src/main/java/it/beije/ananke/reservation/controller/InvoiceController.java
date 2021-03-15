package it.beije.ananke.reservation.controller;

import org.springframework.beans.factory.annotation.Autowired;

import it.beije.ananke.reservation.service.InvoiceService;
import it.beije.ananke.reservation.service.ReservationService;

public class InvoiceController {

	@Autowired
	private InvoiceService invoiceService;
}
