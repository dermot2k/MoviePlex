/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTOs;

import java.util.Date;

/**
 *
 * @author jimmy_2u626cl
 */
public class Bookings {


    private int ScreeningId;
    private int SeatId;
    private String Description;
    private int Reference;
    private String PaymentType;
    private int UserId;

    public Bookings() {

        
    }

    public Bookings(int ScreeningId, int SeatId, String Description, int Reference, String PaymentType, int UserId) {
        this.ScreeningId = ScreeningId;
        this.SeatId = SeatId;
        this.Description = Description;
        this.Reference = Reference;
        this.PaymentType = PaymentType;
        this.UserId = UserId;
    }

    public int getScreeningId() {
        return ScreeningId;
    }

    public void setScreeningId(int ScreeningId) {
        this.ScreeningId = ScreeningId;
    }

    public int getSeatId() {
        return SeatId;
    }

    public void setSeatId(int SeatId) {
        this.SeatId = SeatId;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public int getReference() {
        return Reference;
    }

    public void setReference(int Reference) {
        this.Reference = Reference;
    }

    public String getPaymentType() {
        return PaymentType;
    }

    public void setPaymentType(String PaymentType) {
        this.PaymentType = PaymentType;
    }

    public int getUserId() {
        return UserId;
    }

    public void setUserId(int UserId) {
        this.UserId = UserId;
    }

    @Override
    public String toString() {
        return "Bookings{" + "ScreeningId=" + ScreeningId + ", SeatId=" + SeatId + ", Description=" + Description + ", Reference=" + Reference + ", PaymentType=" + PaymentType + ", UserId=" + UserId + '}';
    }


}