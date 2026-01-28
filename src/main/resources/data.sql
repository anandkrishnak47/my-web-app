-- Sample Users
INSERT INTO users (id, username, email) VALUES (1, 'anand', 'anand@example.com');
INSERT INTO users (id, username, email) VALUES (2, 'john', 'john@example.com');

-- Sample Audit Logs
INSERT INTO audit_logs (id, action, username, timestamp)
VALUES (1, 'Created user', 'anand', CURRENT_TIMESTAMP);

INSERT INTO audit_logs (id, action, username, timestamp)
VALUES (2, 'Created user', 'john', CURRENT_TIMESTAMP);