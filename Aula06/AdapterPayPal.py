class StripePayment:
    def pay(self, amount):
        print(f"Pagamento de ${amount} via Stripe Aprovado.")
        
class PaypalPayment:
    def send_payment(self, amount):
        print(f"Pagamento de ${amount} via PayPal Aprovado")

class PaypalAdapter(StripePayment):
    def __init__(self, paypal_payment):
        self.paypal_payment = paypal_payment
    
    def pay(self, amount):
        self.paypal_payment.send_payment(amount)
    
def process_payment(payment_system, amount):
    payment_system.pay(amount)

StripePayment = StripePayment()
PaypalPayment = PaypalAdapter(PaypalPayment())

process_payment(StripePayment, 100)
process_payment(PaypalPayment, 200)      