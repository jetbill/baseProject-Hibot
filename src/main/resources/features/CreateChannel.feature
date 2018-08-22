Feature: Registar un canal en la plataforma Hibot

@Crear-Canal
Scenario Outline: Ingreso exitoso en Hibot
Given se autentica en la plataforma
When digita email "<email>" y contrasena "<password>"
Then  verifica el ingreso
  And sigue la ruta
  When llena el formulario cuenta "<cuenta>" canal"<canal>" direccion"<direccion>"
  Then verifica el registro "<registro>"



Examples:

|email                        |password  |cuenta   |canal   |direccion|registro |
|william.renteria@sofka.com.co|William123|3165880455|WhatsApp|INBOUND  |3165880455|


