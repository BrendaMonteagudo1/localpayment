# localpayment
Deploy hecho por medio Heroku y documentación Postman.

Deploy Heroku: Se unio el repository, junto con mi usuario en Heroku por medio de Git Bash, para lograr obtener la informacion de deploy y poder generar la documentacion en Postaman.
https://www.heroku.com/    
Documentacion: https://documenter.getpostman.com/view/16169866/TzzGJEJF


Test Unit: Se generaron dos tets LocalPaymentApplicationTests.java para los mismos se generaron dos metodos de validacion dentro de TarjetaService.java entre otras validaciones solicitadas.

Patrón Strategy: Se utlizo para poder generar el metodo calcularTasaPorServicio dentro de TarjetaService.java, ya que por medio de una Interface logramos unir en un  solo metodo las diferentes tasas por el servicio.

Break points: Dentro de la carpeta controller, se encuentran los diferentes controller (Tarjeta, Persona y Auth) con sus break points y rutas, por los cuales pueden generarse Post y Get de Tarjetas y Personas y tambien generar un Login por medio de auntenticacion JWT. 
