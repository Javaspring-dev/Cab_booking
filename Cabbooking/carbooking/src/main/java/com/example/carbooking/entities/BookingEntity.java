package com.example.carbooking.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Booking")
public class BookingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bookingid;
    private int carid;
    private int userid;
    private int starttime;
    private int endtime;

}
