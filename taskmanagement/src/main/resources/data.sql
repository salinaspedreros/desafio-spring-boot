-- Inserta usuarios
INSERT INTO users (username, password) VALUES ('admin', '$2a$12$IKyskvK8M4XXkBpPAGIE2OMIVAwus0Y46d0zR1MnFDYAmMT5a7oBa');
INSERT INTO users (username, password) VALUES ('user', '$2a$12$rozV.EXPWDQgsCj1PVSmp.UwsYTE2rZcGxNZfwtg6B.Yjq0wQhpZO');

-- Inserta Estados de las tareas
INSERT INTO task_status (id, name) VALUES (1, 'Pendiente');
INSERT INTO task_status (id, name) VALUES (2, 'En Proceso');
INSERT INTO task_status (id, name) VALUES (3, 'Completada');

-- Inserta Tareas
INSERT INTO task (title, description, status_id) VALUES (
  'Redactar documentación del proyecto',
  'Escribir la documentación de la API y ejemplos de uso.',
  1
);

INSERT INTO task (title, description, status_id) VALUES (
  'Corregir error de inicio de sesión',
  'Solucionar el problema donde los usuarios no pueden iniciar sesión tras el cierre de sesión.',
  2
);

INSERT INTO task (title, description, status_id) VALUES (
  'Refactorizar el servicio de tareas',
  'Aplicar principios SOLID y buenas prácticas de código limpio.',
  3
);
