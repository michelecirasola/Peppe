﻿using PCarpet.DTO;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace PCarpet
{
    public partial class payment
    {
        public static PaymentDTO toPaymentDTO(payment payment)
        {
            return new PaymentDTO(payment.id, payment.quantity, (int)payment.id_stop);
            //TODO
            //this.slotAddress = payment.slotAddress;
        }
    }
}