import java.time.*;

public class Medicine
{
  private static int nextId = 1;
  private String medicineName;
  private double price;
  private int quantity;
  private LocalDate entryDate;
  private int orderId;

  public Medicine(String medicineName, double price, int quantity, int year, int month, int date)
  {
    this.medicineName = medicineName;
    this.price = price;
    this.quantity = quantity;
    this.entryDate = LocalDate.of(year, month, date);
    this.orderId = nextId;
    nextId++;
  }

  public String getName()
  {
    return medicineName;
  }

  public double getPrice()
  {
    return price;
  }

  public double getQuantity()
  {
    return quantity;
  }

  public LocalDate getEntryDate()
  {
    return entryDate;
  }

  public int getOrderId()
  {
    return orderId;
  }

}
