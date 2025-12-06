# 📦 E-Ticaret Sipariş Durumu Yönetimi (Durum Tasarım Deseni)

Bu proje, bir e-ticaret sistemindeki **Siparişin Yaşam Döngüsünü** yönetmek için **Durum (State) Tasarım Deseni'ni** kullanan basit bir Java uygulamasıdır.

Bu tasarım deseni, **`Order`** (Sipariş) nesnesinin mevcut durumuna bağlı olarak (`Pending`, `Shipped`, `Delivered`, `Cancelled`) davranışının dinamik olarak değişmesini sağlar.



---

## ✨ Projenin Amacı ve Özellikleri

Projenin temel amacı, karmaşık **koşullu mantıkları (if/else veya switch-case)** ortadan kaldırarak her bir durumu kendi sınıfında izole etmektir.

* **Durumların Kapsüllenmesi:** Her sipariş durumu (Beklemede, Kargolandı, Teslim Edildi, İptal Edildi) ayrı bir sınıf ile temsil edilir.
* **Geçiş Kuralları:** Hangi durumda hangi eylemin (Kargolama, Teslim Etme, İptal Etme) geçerli olduğunu her durum sınıfı kendi içinde tanımlar. Örneğin, **Teslim Edilmiş** bir siparişin **iptal** edilemeyeceği kuralı, `DeliveredState` sınıfı içinde belirlenmiştir.
* **Temiz Bağlam (Context):** `Order` sınıfı sadece mevcut durumu tutar ve tüm eylemleri durumu temsil eden sınıfa devreder.

---

## 💻 Kullanılan Teknolojiler

* **Java**

---

## 🛠️ Proje Yapısı

### Durum Deseni Bileşenleri

1.  **Durum Arayüzü (`OrderState`):** Tüm somut durum sınıflarının uygulaması gereken ortak eylemleri (`ship`, `deliver`, `cancel`) tanımlar.

2.  **Somut Durumlar (Concrete States):**
    * `PendingState` (Beklemede)
    * `ShippedState` (Kargolandı)
    * `DeliveredState` (Teslim Edildi)
    * `CancelledState` (İptal Edildi)

3.  **Bağlam (`Order`):** Mevcut sipariş durumunu (`currentState`) tutan ve durum değişikliklerini yöneten ana nesnedir.

### Örnek Sipariş Akışı

Aşağıdaki `Main` metodundaki akış, bir siparişin başarılı bir şekilde teslim edilmesini ve ardından geçersiz bir eylemi dener:

```java
Order order = new Order(new PendingState());

order.ship();      // Pending -> Shipped
order.deliver();   // Shipped -> Delivered
order.cancel();    // Delivered -> Cannot cancel (Eylem reddedilir)


