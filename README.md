# Spring Boot + JWT + VueJS

- Esta pequeña práctica muestra como integrar Spring Boot con autenticación por medio de JWT (JSON Web Token) como backend y su vez para el FrontEnd se utiliza VueJS para acceder a los recursos del Backend.
- Se recomienda el uso del siguiente diagrama para la BD. 

![er][img-mer]

- Puedes guiarte de un anterior proyecto que hice sobre [Spring Boot + JWT](https://github.com/Cruz-Bdllo/Spring-Security-JWT) donde se detalla mas sobre su desarrollo.
- Para el desarrollo del FrontEnd, se comprende de:
    - Log in: Donde el usuario se podrá autenticar y mediante esta el servidor le respondera con su token e información del usuario alojada en la BD, tanto el TOKEN y la información del usuario se guardaran en el **localStorage** del navegador.
    - Sign up: Le permitira al usuario darse de alta en el sistema, a su vez el frontEnd validara el formulario mostrandole al usuario si el **username** o **email** ya estan en uso, eso para una mejor experiencia para el usuario.
    - Home: Es la página principal cuando el usuario se autentica de manera exitosa y a la cual solo podrá acceder el usuario una vez haya iniciado sesión.
    - 404: Es la página a la que el servidor redirecciona cuando el usuario quiere acceder a un recurso que no existe, permitiendole regresar a la anterior página.
    
## Instalación 

### Para el FronEnd:
- Ingresar a la carpeta **frontend**
#### Project setup
> npm install

#### Compiles and hot-reloads for development
> npm run serve

#### Compiles and minifies for production
> npm run build

### Para el BackEnd:
- Ingresar a la carpeta **backend**

#### Limpiar el proyecto (elimina la carpeta target)
> mvn clean

#### Compilar el proyecto
> mvn compile

#### Empaquetar el proyecto
> mvn package

#### Ingresar a la carpeta target
> java -jar [Nombre del proyecto.jar]


## Imagenes del proyecto:

### Página de registro
![signup][img-signup]

### Página Inicio de sesión
![login][img-login]

### Página Home (USER)
![home][img-home]

### Página Home (ADMIN)
![admin][img-admin]

### Validar token
![token][img-token]

### Información del usuario
![info][img-info]


[img-mer]: https://raw.githubusercontent.com/Cruz-Bdllo/Spring-Security-JWT/master/img-project/mer.png "diagrama de Entidad Relación"

[img-signup]: https://raw.githubusercontent.com/Cruz-Bdllo/Spring-Security-JWT-Vuejs/master/imgs/exist_email_user.png "Sign up"

[img-login]: https://raw.githubusercontent.com/Cruz-Bdllo/Spring-Security-JWT-Vuejs/master/imgs/sing_up_success.png "Log in"

[img-home]: https://raw.githubusercontent.com/Cruz-Bdllo/Spring-Security-JWT-Vuejs/master/imgs/home.png "Home User"

[img-admin]: https://raw.githubusercontent.com/Cruz-Bdllo/Spring-Security-JWT-Vuejs/master/imgs/admin.png "Home Admin"

[img-token]: https://raw.githubusercontent.com/Cruz-Bdllo/Spring-Security-JWT-Vuejs/master/imgs/valid_token.png "token"

[img-info]: https://raw.githubusercontent.com/Cruz-Bdllo/Spring-Security-JWT-Vuejs/master/imgs/user.png "Info"