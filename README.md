**#Proyecto Conversor de Monedas con una API ALURA LATAM**

Realice este proyecto de conversor de monedas, tal como su nombre indica convierte monedas a otras monedas, solo recibe tres tipos de moneda Pesos DOminicanos, Dolares y Euros, esta limitacion es para no alargar inncesariamente el codigo, pero sin problema se pueden agregar mas. 

Bien, ahora proseguire a mostrar imagenes de mi codigo y su funcionamiento

**#Clase Principal**
Aqui esta el main principal del programa
![image](https://github.com/Flanguard/ConversorMonedasAPI/assets/160052321/242ebe35-86c8-4329-951c-cefd90a64a3e)
![image](https://github.com/Flanguard/ConversorMonedasAPI/assets/160052321/da2b27ef-3de7-4b47-b8fc-00ed381d2388)
Lo que realizo aqui no es nada mas que llamar a la clase dependencia, que es donde reside casi toda la logica del codigo

**#Clase dependencia**
Esta clase se encarga de realizar toda la logica del codigo, bueno, esta llena de malas practicas, las cuales solucionare en el futuro
![image](https://github.com/Flanguard/ConversorMonedasAPI/assets/160052321/c195eff4-e9d5-44a8-a875-63a1c7c4c2e7)
![image](https://github.com/Flanguard/ConversorMonedasAPI/assets/160052321/b4ea875c-be72-4e02-bf0d-cf06f1b7d3f9)
![image](https://github.com/Flanguard/ConversorMonedasAPI/assets/160052321/5bac5465-ed55-4f3e-b236-1638700fc436)

**#Clase CrearArchivos**
Esta clase se encarga de crear los archivos
![image](https://github.com/Flanguard/ConversorMonedasAPI/assets/160052321/e9a70fef-188b-4df4-88da-7c202abb7ff2)
QUe hago aqui? Bueno creo una instancia Gson para poder convertir mi clase GuardarDatos al formato .json. Dentro de la clase una funcion llamada CrearArchivos que va a recibir una lista de tipo GuardarDatos, y bueno, eso es lo que ira agregando a mi texto.json

**#Clase GuardarDatos**
![image](https://github.com/Flanguard/ConversorMonedasAPI/assets/160052321/8a7ad28a-f814-4db2-9395-5cdce960b76f)
Esta clase solo esta encarga de una sola cosa, guardar los datos.... Ni mas ni menos.

**#RecordClass MisMonedas**
![image](https://github.com/Flanguard/ConversorMonedasAPI/assets/160052321/ef49fb35-d799-489a-8e19-016cb61e02fa)
Esta es la clase es la encargada de tomar el mapa conversion_rates de la api de monedas: https://v6.exchangerate-api.com/v6/INGRESE SU CLAVE API/latest/DOP

**#ConnectarAPI**
![image](https://github.com/Flanguard/ConversorMonedasAPI/assets/160052321/6d029eed-48b6-45cd-9a9d-6b0278d9e656)
Esta es la clase encargada de conectar con el servidor y consumir la API.

Bien, lo primero que hace el codigo cuando lo lanzas es mostrarte un menu con las diferentes opciones a elegir, y te pedira un valor entero a ingresar, si engresas una letra o cualquier otra cosa menso un numero entero el codigo seguir pidiendote el numero entero hasta que lo ingreses, una vez ingreses un numero siempre y cuando este no sea menor que cero o mayor o igual que cinco, la clase dependencia se lanzara, y en dicha clase es donde se encuentre toda la logica de la aplicacion, esta clase hace lo siguiente:

  1- llama a la clase conectar API y busca la clave correspondiente en conversion_reates.

  2- Realiza el calculo de conversion y lo guarda en guardarCalculos

  3- Guarda en la variables guardar el objeto GuardarDatos(El cueal recibe valores)

  4- LLama a la lista guardarDatos y le agrega el objeto guardar

  5- Cambia el nvalor de la variables lanzador y le da la conversion

  6- Sale Estos mismos pasos son los mismos para todos solo cambia la moneda a convertir.

Cabe aclarar que hay una varaible localTime que almacena el tiempo en la maquina, de esta manera el usuario sabra a que hora realizo dicha conversion de monedas.

Aqui esta el video de mi pryecto funcionando 
<iframe width="560" height="315" src="https://www.youtube.com/embed/FvU1APdVaXQ?si=OIpGifq0nunQca3k" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" referrerpolicy="strict-origin-when-cross-origin" allowfullscreen></iframe>
