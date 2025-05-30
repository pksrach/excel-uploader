# 📥 Category Excel Import API

This is a Spring Boot application written in Kotlin that allows you to import category data from an Excel `.xlsx` file into a PostgreSQL database.

- [Template](https://docs.google.com/spreadsheets/d/1nBIf0GY9f7xo_PMy8srxPKF4_EAOsqzzNZL1_CZb37c/edit?usp=sharing)

## 📌 Features

- Import `.xlsx` files via REST API
- Automatically map Excel rows to `Category` entities
- Auto-generate `id` (PostgreSQL `SERIAL`)
- Supports file upload with multipart/form-data
- Uses Apache POI for Excel parsing

## 📦 Technologies

- Kotlin
- Spring Boot (Web + JPA)
- PostgreSQL
- Apache POI
- Gradle

---

## 📁 Excel Template Format

The Excel file must have the following headers in the first row:

| name        | note             |
|-------------|------------------|
| Electronics | Devices & gadgets |
| Furniture   | Office setup     |

- **Do not include an `id` column.**
- The first row is treated as the header.

---

## 🚀 Running the Project

### 1. Clone the Repository

```bash
git clone https://github.com/your-username/category-excel-import.git
cd category-excel-import
