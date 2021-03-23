package it.beije.ananke.reservation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import it.beije.ananke.reservation.model.Invoice;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Integer>{

	@Query(value = "SELECT * from invoice WHERE id = ?1", nativeQuery = true)
	Invoice findByInvoiceId(Integer id);

	
}
