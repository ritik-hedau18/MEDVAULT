# MEDVAULT: Patient-Controlled Encrypted Health Record System

MEDVAULT is a secure, HIPAA-compliant patient-controlled medical records management platform. It ensures complete patient privacy at rest and in transit through dynamic encryption keys, and uses local Spring AI OCR models to parse uploaded documents into structured medical insights.

## Core Features

- **Field-Level AES-256 Encryption**: Patient medical reports and clinical metrics are encrypted in the database at the field level using JPA Attribute Converters.
- **Spring AI & Local OCR**: Automatically extracts vitals, haemoglobin levels, blood sugar, and cholesterol details from diagnostic documents.
- **Integrity Block Hashing**: Every record generates a SHA-256 hash to prevent unauthorized record tempering or modification.
- **Dynamic QR Code sharing**: Patients can generate short-lived QR codes (cryptographic access codes) that clinical professionals scan to unlock decrypted record access temporarily.
- **Dual Portal Security**: Tailored dashboards for patients (timeline tracking, QR code controls, uploading) and doctors (clinical decryption terminal).

## Tech Stack

- **Backend**: Spring Boot 3.3, Java 17, Spring Security (JWT), Spring Data JPA
- **Database**: PostgreSQL (with encrypted text fields)
- **Frontend**: React 18, Vite, TypeScript, Tailwind CSS, Lucide Icons
- **DevOps**: Docker, Docker Compose, Nginx (for static routing)

## Port Mapping

- **Backend REST API**: `http://localhost:8085`
- **Frontend App Dev Server**: `http://localhost:5173`
- **Database**: `localhost:5432` (DB: `medvault_db`)

---

## Local Setup Instructions

### 1. Database Setup
Create a PostgreSQL database named `medvault_db` on port `5432`.

### 2. Run Backend
```bash
cd backend
mvn clean spring-boot:run
```

### 3. Run Frontend
```bash
cd frontend
npm install
npm run dev
```

---

## Docker Compose Setup
To spin up the entire cluster (DB, Backend, and Frontend Nginx server):
```bash
docker-compose up --build -d
```
- Frontend URL (Dockerised): `http://localhost:5175`
- Backend API (Dockerised): `http://localhost:8085`

<!-- Incremental commit checkpoint index #50 -->
<!-- Incremental commit checkpoint index #51 -->

## Update Note (2026-04-28)
- fix: decrypt block rendering error