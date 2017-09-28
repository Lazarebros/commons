/* Populate user_profiles Table */
INSERT INTO user_profiles (profile_id, type) VALUES 
(1, 'ADMIN'),
(2, 'DBA'),
(3, 'USER');

/* Populate users Table */
INSERT INTO users (user_id, user_name, password, first_name, last_name) VALUES
(1, 'admin', '$2a$10$B6veWx.vbEW4CIicr2KYw.A4dcZcIAvSYFMLx6PaJsKUrESK504e2', 'Dayan', 'Lazare'),
(2, 'test', '$2a$10$QuByoxcZkZl1eRiKOWDYrOG55CL6IC9EBcBRE72jjWEsT3JIWm6Ka', 'Test', 'Tester');

/* Populate JOIN Table */
INSERT INTO users_user_profiles (user_id, profile_id)
  SELECT user.user_id, profile.profile_id FROM users user, user_profiles profile
  where user.user_name='admin' and profile.type='ADMIN';

/* Populate JOIN Table */
INSERT INTO users_user_profiles (user_id, profile_id)
  SELECT user.user_id, profile.profile_id FROM users user, user_profiles profile
  where user.user_name='test' and profile.type='USER';
  