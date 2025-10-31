package com.pragyan.controller;


import com.pragyan.entity.Enrollment;
import com.pragyan.repository.EnrollmentRepository;
import com.pragyan.service.RazorpayService;
import com.razorpay.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/enrollments")
@CrossOrigin(origins = "*")
public class EnrollmentController {
    private final EnrollmentRepository repo;
    private final RazorpayService razorpayService;
    public EnrollmentController(EnrollmentRepository repo, RazorpayService razorpayService) {
        this.repo = repo; this.razorpayService = razorpayService;
    }

    @PostMapping("/create-order")
    public ResponseEntity<?> createOrder(@RequestParam int amount, @RequestParam String receipt){
        try {
            Order order = razorpayService.createOrder(amount,"INR",receipt);
            Enrollment e = new Enrollment();
            e.setStatus("CREATED");
            e.setRazorpayOrderId(order.get("id"));
            repo.save(e);
            return ResponseEntity.ok(order.toString());
        } catch(Exception ex) { return ResponseEntity.status(500).body(ex.getMessage()); }
    }

    @PostMapping("/verify")
    public ResponseEntity<String> verify(@RequestBody Map<String,String> payload){
        String orderId = payload.get("razorpay_order_id");
        String paymentId = payload.get("razorpay_payment_id");
        String signature = payload.get("razorpay_signature");
        boolean ok = razorpayService.verifySignature(orderId,paymentId,signature);
        Optional<Enrollment> e = repo.findByRazorpayOrderId(orderId);
        if(e.isPresent()){
            Enrollment en = e.get();
            en.setRazorpayPaymentId(paymentId);
            en.setStatus(ok ? "SUCCESS" : "FAILED");
            repo.save(en);
        }
        return ResponseEntity.ok(ok ? "VERIFIED" : "INVALID");
    }
}

