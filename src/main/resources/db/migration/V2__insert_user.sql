INSERT INTO users (id, membership_id, account_status, registration_date, last_login)
VALUES
  (UUID(), 'user001', 'active', '2025-05-05 17:06:00', '2025-05-05 17:06:00'),
  (UUID(), 'user002', 'active', '2025-05-04 10:00:00', '2025-05-05 16:55:00'),
  (UUID(), 'user003', 'inactive', '2025-05-01 12:30:00', NULL),
  (UUID(), 'user004', 'pending', '2025-05-03 08:45:00', NULL),
  (UUID(), 'user005', 'active', '2025-05-02 19:20:00', '2025-05-05 15:10:00'),
  (UUID(), 'user006', 'active', '2025-05-05 16:00:00', '2025-05-05 16:30:00'),
  (UUID(), 'user007', 'inactive', '2025-04-30 22:15:00', NULL),
  (UUID(), 'user008', 'pending', '2025-05-04 14:05:00', NULL),
  (UUID(), 'user009', 'active', '2025-05-03 07:50:00', '2025-05-05 14:40:00'),
  (UUID(), 'user010', 'active', '2025-05-05 15:30:00', '2025-05-05 17:01:00');