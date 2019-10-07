# CLASES DE EQUIVALENCIA: ServiciosAlquiler.java
## Cada caso de prueba está basado en supuestos de información de la base de datos
	//Pendiente
	a) public abstract int valorMultaRetrasoxDia(int itemId) throws ExcepcionServiciosAlquiler;
		- 1) Excepciones
		~~~
		/**
		* @obj Retorna el cliente con el documento dado
		* @param docu Documento del cliente a consultar
		* @return cliente con documento docu
		* @throws ExcepcionServiciosAlquiler si el cliente no existe
		*/
		public abstract int valorMultaRetrasoxDia(int itemId) throws ExcepcionServiciosAlquiler
		~~~
		2) Clases de equivalencia

		| Número  | Clase de equivalencia (en lenguaje natural o matemático) |   Resultado correcto /incorrecto. |   
		| --- | --- |---|
		| 1  | Parámetros Inválidos |   Resultado incorrecto. |   
		| 2  | Parámetros Correctos y descuento por antelación|   Resultado correcto |   
		| 3  | Parámetros Correctos y descuento por menor de edad|   Resultado correcto |   
		| 4  | Parámetros Correctos y descuento por mayoría de edad|   Resultado correcto |   
		| 5  | Parámetros Correctos, descuento por antelación y menor de edad|   Resultado correcto |   
		| 6  | Parámetros Correctos, descuento por antelación y mayoría de edad|   Resultado correcto |   
		3) Casos de pruebas

		| Número  | Clase de equivalencia  |   Prueba |  Resultado| 
		| --- | --- |---|---|
		| 1  | Parámetros Inválidos |   (-1546666666666666666666666666666666666,2,-1) |   ExcepcionParametrosInvalidos   |
		| 2  | Parámetros Correctos y descuento por antelación|   (666, 21, 30) |  566.1    |   
		| 3  | Parámetros Correctos y descuento por menor de edad|   (1000, 12, 4) |  950|   
		| 4  | Parámetros Correctos y descuento por mayoría de edad|   (10000, 13,69) |  9200 |    
		| 5  | Parámetros Correctos, descuento por antelación y menor de edad|  (5000, 24, 10) |4000 |  
		| 6  | Parámetros Correctos, descuento por antelación y mayoría de edad|  (2000, 25, 77) | 1540   |

		4) Limites de equivalencia

		| Número  | Clase de equivalencia |   Limites |
		| --- | --- |---|
		| 1  | Parámetros Inválidos |   ...(0,0,0) | 
		| 2  | Parámetros Correctos y descuento por antelación|   (1,21,18)  (1,21,65) |  
		| 3  | Parámetros Correctos y descuento por menor de edad|  (1,0,0)  (1,20,17) |  
		| 4  | Parámetros Correctos y descuento por mayoría de edad|   (1,0,66)... |   
		| 5  | Parámetros Correctos, descuento por antelación y menor de edad| (1,21,0)  (1,21,17)  |  
		| 6  | Parámetros Correctos, descuento por antelación y mayoría de edad|  (1,21,66)...  |

		5) Casos de prueba especificos

		| Número  | Clase de equivalencia |   Limites |
		| --- | --- |---|
		| 1  | Parámetros Inválidos |   (0,0,0) (-1546666666666666666666666666666666666,2,-1)| 
		| 2  | Parámetros Correctos y descuento por antelación|   (1,21,18)  (1,21,65)  (666, 21, 30)|  
		| 3  | Parámetros Correctos y descuento por menor de edad|  (1,0,0)  (1,20,17)  (1000, 12, 4) |  
		| 4  | Parámetros Correctos y descuento por mayoría de edad|   (1,0,66) (10000, 13,69) |   
		| 5  | Parámetros Correctos, descuento por antelación y menor de edad| (1,21,0)  (1,21,17)  (5000, 24, 10) |  
		| 6  | Parámetros Correctos, descuento por antelación y mayoría de edad|  (1,21,66) (2000, 25, 77) |


	//OK
	b) public abstract Cliente consultarCliente(long docu) throws ExcepcionServiciosAlquiler;
		- 1) Excepciones
		~~~
		/**
		* @obj Retorna el cliente con el documento dado
		* @param docu Documento del cliente a consultar
		* @return cliente con documento docu
		* @throws ExcepcionServiciosAlquiler
		*/
	    public abstract Cliente consultarCliente(long docu) throws ExcepcionServiciosAlquiler;
		~~~
		2) Clases de equivalencia

		| Número  | Clase de equivalencia (en lenguaje natural o matemático) |   Resultado correcto /incorrecto. |   
		| --- | --- |---|
		| 1  | El cliente existe |   El cliente esperado |   
		| 2  | El cliente no existe|   null |     
		3) Casos de pruebas

		| Número  | Clase de equivalencia  |   Prueba |  Resultado| 
		| --- | --- |---|---|
		| 1  | El cliente existe |    2020202|"el macho" |   
		| 2  | El cliente no existe|   10999900050 | null| 
		

		4) Limites de equivalencia: No hay límites

		5) Casos de prueba especificos

		| Número  | Clase de equivalencia |   Limites |
		| --- | --- |---|---|
		| 1  | El cliente existe |    2020202, 401 |   
		| 2  | El cliente no existe|   500, 666 |
		
		
	c) public abstract List<ItemRentado> consultarItemsCliente(long idcliente) throws ExcepcionServiciosAlquiler;
		- 1) Excepciones
		~~~
		/**
	    * @obj Consultar los items que tenga en su poder un cliente
	    * @param idcliente identificador del cliente
	    * @return el litado de detalle de los items rentados por el cliente
	    * identificado con 'idcliente'
	    * @throws ExcepcionServiciosAlquiler si el cliente no está registrado
	    */
	    public abstract List<ItemRentado> consultarItemsCliente(long idcliente) throws ExcepcionServiciosAlquiler;
		~~~
		2) Clases de equivalencia

		| Número  | Clase de equivalencia (en lenguaje natural o matemático) |   Resultado correcto /incorrecto. |   
		| --- | --- |---|
		| 1  | No registrado |   ExcepcionServiciosAlquiler |   
		| 2  | Registrado y sin items|   Sin items |   
		| 3  | Registrado y con items|   Tiene al menos un item |   
		  
		3) Casos de pruebas

		| Número  | Clase de equivalencia  |   Prueba |  Resultado| 
		| --- | --- |---|---|
		| 1  | No registrado | 500, 666 |ExcepcionServiciosAlquiler |   
		| 2  | Registrado y sin items|  2020202, 401 |0 items |   
		| 3  | Registrado y con items|  1,2 |1 items y 2 items |  

		4) Limites de equivalencia: No hay limites

		| Número  | Clase de equivalencia |   Limites |
		| --- | --- |---|
		| 1  | No registrado | --- |
		| 2  | Registrado y sin items|  --- |
		| 3  | Registrado y con items|  --- | 

		5) Casos de prueba especificos

		| Número  | Clase de equivalencia |   Limites |
		| --- | --- |---|
		| 1  | No registrado | 500, 666 |  
		| 2  | Registrado y sin items|  2020202, 401 | 
		| 3  | Registrado y con items|  1,2 |//PREGUNTAR_POR_REGISTRAR_ITEM

	d) public abstract List<Cliente> consultarClientes() throws ExcepcionServiciosAlquiler;
		- 1) Excepciones
		~~~
		/**
		* @obj Retorna todos los clientes registrados
		* @return Colección de clientes regsitrados
		* @throws ExcepcionServiciosAlquiler
		*/
	    public abstract List<Cliente> consultarClientes() throws ExcepcionServiciosAlquiler;
		~~~
		2) Clases de equivalencia

		| Número  | Clase de equivalencia (en lenguaje natural o matemático) |   Resultado correcto /incorrecto. |   
		| --- | --- |---|
		| 1  | No hay clientes |   0 |   
		| 2  | Hay mas de un cliente|   length>0 |   
		   
		3) Casos de pruebas

		| Número  | Clase de equivalencia  |   Prueba |  Resultado| 
		| --- | --- |---|---|
		| 1  | No hay clientes |   antes de insertar |  0 |
		| 2  | Hay mas de un cliente|   despues de insertar | >0 | 
		

		4) Limites de equivalencia: No hay limites

		5) Casos de prueba especificos

		| Número  | Clase de equivalencia |   Limites |
		| --- | --- |---|
		| --- | --- |---|---|
		| 1  | No hay clientes |   antes de insertar |
		| 2  | Hay mas de un cliente|   despues de insertar |
	e) public abstract Item consultarItem(int id) throws ExcepcionServiciosAlquiler;
		- 1) Excepciones
		~~~
		/**
		* @obj retorna el item con el id dado
		* @param id del item a consultar
		* @return
		* @throws ExcepcionServiciosAlquiler Si el item no existe
		*/
	    public abstract Item consultarItem(int id) throws ExcepcionServiciosAlquiler;
		~~~
		2) Clases de equivalencia

		| Número  | Clase de equivalencia (en lenguaje natural o matemático) |   Resultado correcto /incorrecto. |   
		| --- | --- |---|
		| 1  | El item no existe |   ExcepcionServiciosAlquiler |   
		| 2  | El item existe|   El item esperado |     
		3) Casos de pruebas

		| Número  | Clase de equivalencia  |   Prueba |  Resultado| 
		| --- | --- |---|---|
		| 1  | Parámetros Inválidos |   (-1546666666666666666666666666666666666,2,-1) |   ExcepcionParametrosInvalidos   |
		| 2  | Parámetros Correctos y descuento por antelación|   (666, 21, 30) |  566.1    |   
		| 3  | Parámetros Correctos y descuento por menor de edad|   (1000, 12, 4) |  950|   
		| 4  | Parámetros Correctos y descuento por mayoría de edad|   (10000, 13,69) |  9200 |    
		| 5  | Parámetros Correctos, descuento por antelación y menor de edad|  (5000, 24, 10) |4000 |  
		| 6  | Parámetros Correctos, descuento por antelación y mayoría de edad|  (2000, 25, 77) | 1540   |

		4) Limites de equivalencia

		| Número  | Clase de equivalencia |   Limites |
		| --- | --- |---|
		| 1  | Parámetros Inválidos |   ...(0,0,0) | 
		| 2  | Parámetros Correctos y descuento por antelación|   (1,21,18)  (1,21,65) |  
		| 3  | Parámetros Correctos y descuento por menor de edad|  (1,0,0)  (1,20,17) |  
		| 4  | Parámetros Correctos y descuento por mayoría de edad|   (1,0,66)... |   
		| 5  | Parámetros Correctos, descuento por antelación y menor de edad| (1,21,0)  (1,21,17)  |  
		| 6  | Parámetros Correctos, descuento por antelación y mayoría de edad|  (1,21,66)...  |

		5) Casos de prueba especificos

		| Número  | Clase de equivalencia |   Limites |
		| --- | --- |---|
		| 1  | Parámetros Inválidos |   (0,0,0) (-1546666666666666666666666666666666666,2,-1)| 
		| 2  | Parámetros Correctos y descuento por antelación|   (1,21,18)  (1,21,65)  (666, 21, 30)|  
		| 3  | Parámetros Correctos y descuento por menor de edad|  (1,0,0)  (1,20,17)  (1000, 12, 4) |  
		| 4  | Parámetros Correctos y descuento por mayoría de edad|   (1,0,66) (10000, 13,69) |   
		| 5  | Parámetros Correctos, descuento por antelación y menor de edad| (1,21,0)  (1,21,17)  (5000, 24, 10) |  
		| 6  | Parámetros Correctos, descuento por antelación y mayoría de edad|  (1,21,66) (2000, 25, 77) |

	f) public abstract List<Item> consultarItemsDisponibles() throws ExcepcionServiciosAlquiler;
		- 1) Excepciones
		~~~
		/**
	    * @obj consultar los items que estan disponibles para alquiler
	    * @return el listado de items disponibles
	    */
	    public abstract List<Item> consultarItemsDisponibles() throws ExcepcionServiciosAlquiler;
		~~~
		2) Clases de equivalencia

		| Número  | Clase de equivalencia (en lenguaje natural o matemático) |   Resultado correcto /incorrecto. |   
		| --- | --- |---|
		| 1  | Parámetros Inválidos |   Resultado incorrecto. |   
		| 2  | Parámetros Correctos y descuento por antelación|   Resultado correcto |   
		| 3  | Parámetros Correctos y descuento por menor de edad|   Resultado correcto |   
		| 4  | Parámetros Correctos y descuento por mayoría de edad|   Resultado correcto |   
		| 5  | Parámetros Correctos, descuento por antelación y menor de edad|   Resultado correcto |   
		| 6  | Parámetros Correctos, descuento por antelación y mayoría de edad|   Resultado correcto |   
		3) Casos de pruebas

		| Número  | Clase de equivalencia  |   Prueba |  Resultado| 
		| --- | --- |---|---|
		| 1  | Parámetros Inválidos |   (-1546666666666666666666666666666666666,2,-1) |   ExcepcionParametrosInvalidos   |
		| 2  | Parámetros Correctos y descuento por antelación|   (666, 21, 30) |  566.1    |   
		| 3  | Parámetros Correctos y descuento por menor de edad|   (1000, 12, 4) |  950|   
		| 4  | Parámetros Correctos y descuento por mayoría de edad|   (10000, 13,69) |  9200 |    
		| 5  | Parámetros Correctos, descuento por antelación y menor de edad|  (5000, 24, 10) |4000 |  
		| 6  | Parámetros Correctos, descuento por antelación y mayoría de edad|  (2000, 25, 77) | 1540   |

		4) Limites de equivalencia

		| Número  | Clase de equivalencia |   Limites |
		| --- | --- |---|
		| 1  | Parámetros Inválidos |   ...(0,0,0) | 
		| 2  | Parámetros Correctos y descuento por antelación|   (1,21,18)  (1,21,65) |  
		| 3  | Parámetros Correctos y descuento por menor de edad|  (1,0,0)  (1,20,17) |  
		| 4  | Parámetros Correctos y descuento por mayoría de edad|   (1,0,66)... |   
		| 5  | Parámetros Correctos, descuento por antelación y menor de edad| (1,21,0)  (1,21,17)  |  
		| 6  | Parámetros Correctos, descuento por antelación y mayoría de edad|  (1,21,66)...  |

		5) Casos de prueba especificos

		| Número  | Clase de equivalencia |   Limites |
		| --- | --- |---|
		| 1  | Parámetros Inválidos |   (0,0,0) (-1546666666666666666666666666666666666,2,-1)| 
		| 2  | Parámetros Correctos y descuento por antelación|   (1,21,18)  (1,21,65)  (666, 21, 30)|  
		| 3  | Parámetros Correctos y descuento por menor de edad|  (1,0,0)  (1,20,17)  (1000, 12, 4) |  
		| 4  | Parámetros Correctos y descuento por mayoría de edad|   (1,0,66) (10000, 13,69) |   
		| 5  | Parámetros Correctos, descuento por antelación y menor de edad| (1,21,0)  (1,21,17)  (5000, 24, 10) |  
		| 6  | Parámetros Correctos, descuento por antelación y mayoría de edad|  (1,21,66) (2000, 25, 77) |

	g) public abstract int valorMultaRetrasoxDia(int itemId) throws ExcepcionServiciosAlquiler;
		- 1) Excepciones
		~~~
		/**
	    * @obj consultar el valor de la multa del alquiler, dado el id del item
	    * alquilado hasta la fecha dada como parametro
	    * @param iditem el codigo del item alquilado
	    * @param fechaDevolucion la fecha de devolucion del item
	    * @return la multa en funcion del numero de dias de retraso. Si el item se
	    * entrega en la fecha exacta de entrega, o antes, la multa sera cero.
	    * @throws ExcepcionServiciosAlquiler si el item no existe o no esta
	    * actualmente alquilado
	    */
	    public abstract long consultarMultaAlquiler(int iditem, Date fechaDevolucion) throws ExcepcionServiciosAlquiler;
		~~~
		2) Clases de equivalencia

		| Número  | Clase de equivalencia (en lenguaje natural o matemático) |   Resultado correcto /incorrecto. |   
		| --- | --- |---|
		| 1  | Parámetros Inválidos |   Resultado incorrecto. |   
		| 2  | Parámetros Correctos y descuento por antelación|   Resultado correcto |   
		| 3  | Parámetros Correctos y descuento por menor de edad|   Resultado correcto |   
		| 4  | Parámetros Correctos y descuento por mayoría de edad|   Resultado correcto |   
		| 5  | Parámetros Correctos, descuento por antelación y menor de edad|   Resultado correcto |   
		| 6  | Parámetros Correctos, descuento por antelación y mayoría de edad|   Resultado correcto |   
		3) Casos de pruebas

		| Número  | Clase de equivalencia  |   Prueba |  Resultado| 
		| --- | --- |---|---|
		| 1  | Parámetros Inválidos |   (-1546666666666666666666666666666666666,2,-1) |   ExcepcionParametrosInvalidos   |
		| 2  | Parámetros Correctos y descuento por antelación|   (666, 21, 30) |  566.1    |   
		| 3  | Parámetros Correctos y descuento por menor de edad|   (1000, 12, 4) |  950|   
		| 4  | Parámetros Correctos y descuento por mayoría de edad|   (10000, 13,69) |  9200 |    
		| 5  | Parámetros Correctos, descuento por antelación y menor de edad|  (5000, 24, 10) |4000 |  
		| 6  | Parámetros Correctos, descuento por antelación y mayoría de edad|  (2000, 25, 77) | 1540   |

		4) Limites de equivalencia

		| Número  | Clase de equivalencia |   Limites |
		| --- | --- |---|
		| 1  | Parámetros Inválidos |   ...(0,0,0) | 
		| 2  | Parámetros Correctos y descuento por antelación|   (1,21,18)  (1,21,65) |  
		| 3  | Parámetros Correctos y descuento por menor de edad|  (1,0,0)  (1,20,17) |  
		| 4  | Parámetros Correctos y descuento por mayoría de edad|   (1,0,66)... |   
		| 5  | Parámetros Correctos, descuento por antelación y menor de edad| (1,21,0)  (1,21,17)  |  
		| 6  | Parámetros Correctos, descuento por antelación y mayoría de edad|  (1,21,66)...  |

		5) Casos de prueba especificos

		| Número  | Clase de equivalencia |   Limites |
		| --- | --- |---|
		| 1  | Parámetros Inválidos |   (0,0,0) (-1546666666666666666666666666666666666,2,-1)| 
		| 2  | Parámetros Correctos y descuento por antelación|   (1,21,18)  (1,21,65)  (666, 21, 30)|  
		| 3  | Parámetros Correctos y descuento por menor de edad|  (1,0,0)  (1,20,17)  (1000, 12, 4) |  
		| 4  | Parámetros Correctos y descuento por mayoría de edad|   (1,0,66) (10000, 13,69) |   
		| 5  | Parámetros Correctos, descuento por antelación y menor de edad| (1,21,0)  (1,21,17)  (5000, 24, 10) |  
		| 6  | Parámetros Correctos, descuento por antelación y mayoría de edad|  (1,21,66) (2000, 25, 77) |

	h) public abstract TipoItem consultarTipoItem(int id) throws ExcepcionServiciosAlquiler;
		- 1) Excepciones
		~~~
		/**
		* @obj Retorna el tipo de item especificado
		* @param id Id del cliente especificado
		* @return
		* @throws ExcepcionServiciosAlquiler
		*/
	    public abstract TipoItem consultarTipoItem(int id) throws ExcepcionServiciosAlquiler;
		~~~
		2) Clases de equivalencia

		| Número  | Clase de equivalencia (en lenguaje natural o matemático) |   Resultado correcto /incorrecto. |   
		| --- | --- |---|
		| 1  | Parámetros Inválidos |   Resultado incorrecto. |   
		| 2  | Parámetros Correctos y descuento por antelación|   Resultado correcto |   
		| 3  | Parámetros Correctos y descuento por menor de edad|   Resultado correcto |   
		| 4  | Parámetros Correctos y descuento por mayoría de edad|   Resultado correcto |   
		| 5  | Parámetros Correctos, descuento por antelación y menor de edad|   Resultado correcto |   
		| 6  | Parámetros Correctos, descuento por antelación y mayoría de edad|   Resultado correcto |   
		3) Casos de pruebas

		| Número  | Clase de equivalencia  |   Prueba |  Resultado| 
		| --- | --- |---|---|
		| 1  | Parámetros Inválidos |   (-1546666666666666666666666666666666666,2,-1) |   ExcepcionParametrosInvalidos   |
		| 2  | Parámetros Correctos y descuento por antelación|   (666, 21, 30) |  566.1    |   
		| 3  | Parámetros Correctos y descuento por menor de edad|   (1000, 12, 4) |  950|   
		| 4  | Parámetros Correctos y descuento por mayoría de edad|   (10000, 13,69) |  9200 |    
		| 5  | Parámetros Correctos, descuento por antelación y menor de edad|  (5000, 24, 10) |4000 |  
		| 6  | Parámetros Correctos, descuento por antelación y mayoría de edad|  (2000, 25, 77) | 1540   |

		4) Limites de equivalencia

		| Número  | Clase de equivalencia |   Limites |
		| --- | --- |---|
		| 1  | Parámetros Inválidos |   ...(0,0,0) | 
		| 2  | Parámetros Correctos y descuento por antelación|   (1,21,18)  (1,21,65) |  
		| 3  | Parámetros Correctos y descuento por menor de edad|  (1,0,0)  (1,20,17) |  
		| 4  | Parámetros Correctos y descuento por mayoría de edad|   (1,0,66)... |   
		| 5  | Parámetros Correctos, descuento por antelación y menor de edad| (1,21,0)  (1,21,17)  |  
		| 6  | Parámetros Correctos, descuento por antelación y mayoría de edad|  (1,21,66)...  |

		5) Casos de prueba especificos

		| Número  | Clase de equivalencia |   Limites |
		| --- | --- |---|
		| 1  | Parámetros Inválidos |   (0,0,0) (-1546666666666666666666666666666666666,2,-1)| 
		| 2  | Parámetros Correctos y descuento por antelación|   (1,21,18)  (1,21,65)  (666, 21, 30)|  
		| 3  | Parámetros Correctos y descuento por menor de edad|  (1,0,0)  (1,20,17)  (1000, 12, 4) |  
		| 4  | Parámetros Correctos y descuento por mayoría de edad|   (1,0,66) (10000, 13,69) |   
		| 5  | Parámetros Correctos, descuento por antelación y menor de edad| (1,21,0)  (1,21,17)  (5000, 24, 10) |  
		| 6  | Parámetros Correctos, descuento por antelación y mayoría de edad|  (1,21,66) (2000, 25, 77) |

	i) public abstract List<TipoItem> consultarTiposItem() throws ExcepcionServiciosAlquiler;
		- 1) Excepciones
		~~~
		/**
		* @obj Retorna todos los tipos de items registrados
		* @return colección de Tipos de items
		* @throws ExcepcionServiciosAlquiler
		*/
	    public abstract List<TipoItem> consultarTiposItem() throws ExcepcionServiciosAlquiler;
		~~~
		2) Clases de equivalencia

		| Número  | Clase de equivalencia (en lenguaje natural o matemático) |   Resultado correcto /incorrecto. |   
		| --- | --- |---|
		| 1  | Parámetros Inválidos |   Resultado incorrecto. |   
		| 2  | Parámetros Correctos y descuento por antelación|   Resultado correcto |   
		| 3  | Parámetros Correctos y descuento por menor de edad|   Resultado correcto |   
		| 4  | Parámetros Correctos y descuento por mayoría de edad|   Resultado correcto |   
		| 5  | Parámetros Correctos, descuento por antelación y menor de edad|   Resultado correcto |   
		| 6  | Parámetros Correctos, descuento por antelación y mayoría de edad|   Resultado correcto |   
		3) Casos de pruebas

		| Número  | Clase de equivalencia  |   Prueba |  Resultado| 
		| --- | --- |---|---|
		| 1  | Parámetros Inválidos |   (-1546666666666666666666666666666666666,2,-1) |   ExcepcionParametrosInvalidos   |
		| 2  | Parámetros Correctos y descuento por antelación|   (666, 21, 30) |  566.1    |   
		| 3  | Parámetros Correctos y descuento por menor de edad|   (1000, 12, 4) |  950|   
		| 4  | Parámetros Correctos y descuento por mayoría de edad|   (10000, 13,69) |  9200 |    
		| 5  | Parámetros Correctos, descuento por antelación y menor de edad|  (5000, 24, 10) |4000 |  
		| 6  | Parámetros Correctos, descuento por antelación y mayoría de edad|  (2000, 25, 77) | 1540   |

		4) Limites de equivalencia

		| Número  | Clase de equivalencia |   Limites |
		| --- | --- |---|
		| 1  | Parámetros Inválidos |   ...(0,0,0) | 
		| 2  | Parámetros Correctos y descuento por antelación|   (1,21,18)  (1,21,65) |  
		| 3  | Parámetros Correctos y descuento por menor de edad|  (1,0,0)  (1,20,17) |  
		| 4  | Parámetros Correctos y descuento por mayoría de edad|   (1,0,66)... |   
		| 5  | Parámetros Correctos, descuento por antelación y menor de edad| (1,21,0)  (1,21,17)  |  
		| 6  | Parámetros Correctos, descuento por antelación y mayoría de edad|  (1,21,66)...  |

		5) Casos de prueba especificos

		| Número  | Clase de equivalencia |   Limites |
		| --- | --- |---|
		| 1  | Parámetros Inválidos |   (0,0,0) (-1546666666666666666666666666666666666,2,-1)| 
		| 2  | Parámetros Correctos y descuento por antelación|   (1,21,18)  (1,21,65)  (666, 21, 30)|  
		| 3  | Parámetros Correctos y descuento por menor de edad|  (1,0,0)  (1,20,17)  (1000, 12, 4) |  
		| 4  | Parámetros Correctos y descuento por mayoría de edad|   (1,0,66) (10000, 13,69) |   
		| 5  | Parámetros Correctos, descuento por antelación y menor de edad| (1,21,0)  (1,21,17)  (5000, 24, 10) |  
		| 6  | Parámetros Correctos, descuento por antelación y mayoría de edad|  (1,21,66) (2000, 25, 77) |

	j) public abstract void registrarAlquilerCliente(Date date, long docu, Item item, int numdias) throws ExcepcionServiciosAlquiler;
		- 1) Excepciones
		~~~
		/**
	    * @obj rejistrar el alkiler de un item
	    * @pre numdias >=1
	    * @param date fecha de rejistro del alquiler
	    * @param docu identificacion de a quien se le cargara el alquiler
	    * @param item el identificador del item a alquilar
	    * @param numdias el numero de dias que se le prestara el item
	    * @pos el item ya no debe estar disponible, y debe estar asignado al
	    * cliente
	    * @throws ExcepcionXX si el identificador no corresponde con un item, o si
	    * el mismo ya esta alquilado
	    */
	    public abstract void registrarAlquilerCliente(Date date, long docu, Item item, int numdias) throws ExcepcionServiciosAlquiler;
		~~~
		2) Clases de equivalencia

		| Número  | Clase de equivalencia (en lenguaje natural o matemático) |   Resultado correcto /incorrecto. |   
		| --- | --- |---|
		| 1  | Parámetros Inválidos |   Resultado incorrecto. |   
		| 2  | Parámetros Correctos y descuento por antelación|   Resultado correcto |   
		| 3  | Parámetros Correctos y descuento por menor de edad|   Resultado correcto |   
		| 4  | Parámetros Correctos y descuento por mayoría de edad|   Resultado correcto |   
		| 5  | Parámetros Correctos, descuento por antelación y menor de edad|   Resultado correcto |   
		| 6  | Parámetros Correctos, descuento por antelación y mayoría de edad|   Resultado correcto |   
		3) Casos de pruebas

		| Número  | Clase de equivalencia  |   Prueba |  Resultado| 
		| --- | --- |---|---|
		| 1  | Parámetros Inválidos |   (-1546666666666666666666666666666666666,2,-1) |   ExcepcionParametrosInvalidos   |
		| 2  | Parámetros Correctos y descuento por antelación|   (666, 21, 30) |  566.1    |   
		| 3  | Parámetros Correctos y descuento por menor de edad|   (1000, 12, 4) |  950|   
		| 4  | Parámetros Correctos y descuento por mayoría de edad|   (10000, 13,69) |  9200 |    
		| 5  | Parámetros Correctos, descuento por antelación y menor de edad|  (5000, 24, 10) |4000 |  
		| 6  | Parámetros Correctos, descuento por antelación y mayoría de edad|  (2000, 25, 77) | 1540   |

		4) Limites de equivalencia

		| Número  | Clase de equivalencia |   Limites |
		| --- | --- |---|
		| 1  | Parámetros Inválidos |   ...(0,0,0) | 
		| 2  | Parámetros Correctos y descuento por antelación|   (1,21,18)  (1,21,65) |  
		| 3  | Parámetros Correctos y descuento por menor de edad|  (1,0,0)  (1,20,17) |  
		| 4  | Parámetros Correctos y descuento por mayoría de edad|   (1,0,66)... |   
		| 5  | Parámetros Correctos, descuento por antelación y menor de edad| (1,21,0)  (1,21,17)  |  
		| 6  | Parámetros Correctos, descuento por antelación y mayoría de edad|  (1,21,66)...  |

		5) Casos de prueba especificos

		| Número  | Clase de equivalencia |   Limites |
		| --- | --- |---|
		| 1  | Parámetros Inválidos |   (0,0,0) (-1546666666666666666666666666666666666,2,-1)| 
		| 2  | Parámetros Correctos y descuento por antelación|   (1,21,18)  (1,21,65)  (666, 21, 30)|  
		| 3  | Parámetros Correctos y descuento por menor de edad|  (1,0,0)  (1,20,17)  (1000, 12, 4) |  
		| 4  | Parámetros Correctos y descuento por mayoría de edad|   (1,0,66) (10000, 13,69) |   
		| 5  | Parámetros Correctos, descuento por antelación y menor de edad| (1,21,0)  (1,21,17)  (5000, 24, 10) |  
		| 6  | Parámetros Correctos, descuento por antelación y mayoría de edad|  (1,21,66) (2000, 25, 77) |

	k) public abstract void registrarCliente(Cliente p) throws ExcepcionServiciosAlquiler;
		- 1) Excepciones
		~~~
		/**
		* @obj Registra un nuevo cliente
		* @param p Cliente a registrar
		* @throws ExcepcionServiciosAlquiler Si el cliente ya está registrado
		*/
	    public abstract void registrarCliente(Cliente p) throws ExcepcionServiciosAlquiler;
		~~~
		2) Clases de equivalencia

		| Número  | Clase de equivalencia (en lenguaje natural o matemático) |   Resultado correcto /incorrecto. |   
		| --- | --- |---|
		| 1  | Parámetros Inválidos |   Resultado incorrecto. |   
		| 2  | Parámetros Correctos y descuento por antelación|   Resultado correcto |   
		| 3  | Parámetros Correctos y descuento por menor de edad|   Resultado correcto |   
		| 4  | Parámetros Correctos y descuento por mayoría de edad|   Resultado correcto |   
		| 5  | Parámetros Correctos, descuento por antelación y menor de edad|   Resultado correcto |   
		| 6  | Parámetros Correctos, descuento por antelación y mayoría de edad|   Resultado correcto |   
		3) Casos de pruebas

		| Número  | Clase de equivalencia  |   Prueba |  Resultado| 
		| --- | --- |---|---|
		| 1  | Parámetros Inválidos |   (-1546666666666666666666666666666666666,2,-1) |   ExcepcionParametrosInvalidos   |
		| 2  | Parámetros Correctos y descuento por antelación|   (666, 21, 30) |  566.1    |   
		| 3  | Parámetros Correctos y descuento por menor de edad|   (1000, 12, 4) |  950|   
		| 4  | Parámetros Correctos y descuento por mayoría de edad|   (10000, 13,69) |  9200 |    
		| 5  | Parámetros Correctos, descuento por antelación y menor de edad|  (5000, 24, 10) |4000 |  
		| 6  | Parámetros Correctos, descuento por antelación y mayoría de edad|  (2000, 25, 77) | 1540   |

		4) Limites de equivalencia

		| Número  | Clase de equivalencia |   Limites |
		| --- | --- |---|
		| 1  | Parámetros Inválidos |   ...(0,0,0) | 
		| 2  | Parámetros Correctos y descuento por antelación|   (1,21,18)  (1,21,65) |  
		| 3  | Parámetros Correctos y descuento por menor de edad|  (1,0,0)  (1,20,17) |  
		| 4  | Parámetros Correctos y descuento por mayoría de edad|   (1,0,66)... |   
		| 5  | Parámetros Correctos, descuento por antelación y menor de edad| (1,21,0)  (1,21,17)  |  
		| 6  | Parámetros Correctos, descuento por antelación y mayoría de edad|  (1,21,66)...  |

		5) Casos de prueba especificos

		| Número  | Clase de equivalencia |   Limites |
		| --- | --- |---|
		| 1  | Parámetros Inválidos |   (0,0,0) (-1546666666666666666666666666666666666,2,-1)| 
		| 2  | Parámetros Correctos y descuento por antelación|   (1,21,18)  (1,21,65)  (666, 21, 30)|  
		| 3  | Parámetros Correctos y descuento por menor de edad|  (1,0,0)  (1,20,17)  (1000, 12, 4) |  
		| 4  | Parámetros Correctos y descuento por mayoría de edad|   (1,0,66) (10000, 13,69) |   
		| 5  | Parámetros Correctos, descuento por antelación y menor de edad| (1,21,0)  (1,21,17)  (5000, 24, 10) |  
		| 6  | Parámetros Correctos, descuento por antelación y mayoría de edad|  (1,21,66) (2000, 25, 77) |

	l) public abstract long consultarCostoAlquiler(int iditem, int numdias) throws ExcepcionServiciosAlquiler;
		- 1) Excepciones
		~~~
		/**
	    * @obj consultar el costo del alquiler de un item
	    * @pre numdias >=1
	    * @param iditem el codigo del item
	    * @param numdias el numero de dias que se va a alquilar
	    * @return el costo total del alquiler, teniendo en cuesta el costo diario y
	    * el numeo de dias del alquiler
	    * @throws ExcepcionServiciosAlquiler si el identificador del item no existe
	    */
	    public abstract long consultarCostoAlquiler(int iditem, int numdias) throws ExcepcionServiciosAlquiler;
		~~~
		2) Clases de equivalencia

		| Número  | Clase de equivalencia (en lenguaje natural o matemático) |   Resultado correcto /incorrecto. |   
		| --- | --- |---|
		| 1  | Parámetros Inválidos |   Resultado incorrecto. |   
		| 2  | Parámetros Correctos y descuento por antelación|   Resultado correcto |   
		| 3  | Parámetros Correctos y descuento por menor de edad|   Resultado correcto |   
		| 4  | Parámetros Correctos y descuento por mayoría de edad|   Resultado correcto |   
		| 5  | Parámetros Correctos, descuento por antelación y menor de edad|   Resultado correcto |   
		| 6  | Parámetros Correctos, descuento por antelación y mayoría de edad|   Resultado correcto |   
		3) Casos de pruebas

		| Número  | Clase de equivalencia  |   Prueba |  Resultado| 
		| --- | --- |---|---|
		| 1  | Parámetros Inválidos |   (-1546666666666666666666666666666666666,2,-1) |   ExcepcionParametrosInvalidos   |
		| 2  | Parámetros Correctos y descuento por antelación|   (666, 21, 30) |  566.1    |   
		| 3  | Parámetros Correctos y descuento por menor de edad|   (1000, 12, 4) |  950|   
		| 4  | Parámetros Correctos y descuento por mayoría de edad|   (10000, 13,69) |  9200 |    
		| 5  | Parámetros Correctos, descuento por antelación y menor de edad|  (5000, 24, 10) |4000 |  
		| 6  | Parámetros Correctos, descuento por antelación y mayoría de edad|  (2000, 25, 77) | 1540   |

		4) Limites de equivalencia

		| Número  | Clase de equivalencia |   Limites |
		| --- | --- |---|
		| 1  | Parámetros Inválidos |   ...(0,0,0) | 
		| 2  | Parámetros Correctos y descuento por antelación|   (1,21,18)  (1,21,65) |  
		| 3  | Parámetros Correctos y descuento por menor de edad|  (1,0,0)  (1,20,17) |  
		| 4  | Parámetros Correctos y descuento por mayoría de edad|   (1,0,66)... |   
		| 5  | Parámetros Correctos, descuento por antelación y menor de edad| (1,21,0)  (1,21,17)  |  
		| 6  | Parámetros Correctos, descuento por antelación y mayoría de edad|  (1,21,66)...  |

		5) Casos de prueba especificos

		| Número  | Clase de equivalencia |   Limites |
		| --- | --- |---|
		| 1  | Parámetros Inválidos |   (0,0,0) (-1546666666666666666666666666666666666,2,-1)| 
		| 2  | Parámetros Correctos y descuento por antelación|   (1,21,18)  (1,21,65)  (666, 21, 30)|  
		| 3  | Parámetros Correctos y descuento por menor de edad|  (1,0,0)  (1,20,17)  (1000, 12, 4) |  
		| 4  | Parámetros Correctos y descuento por mayoría de edad|   (1,0,66) (10000, 13,69) |   
		| 5  | Parámetros Correctos, descuento por antelación y menor de edad| (1,21,0)  (1,21,17)  (5000, 24, 10) |  
		| 6  | Parámetros Correctos, descuento por antelación y mayoría de edad|  (1,21,66) (2000, 25, 77) |

	
	m) public abstract void actualizarTarifaItem(int id, long tarifa) throws ExcepcionServiciosAlquiler;
		- 1) Excepciones
		~~~
		/**
		* @obj Actualiza la tarifa de un item
		* @pre tarifa>=0
		* @param id Del Item a consultar
		* @param tarifa La nueva tarifa del item
		* @throws ExcepcionServiciosAlquiler si el item no existe
		*/
	    public abstract void actualizarTarifaItem(int id, long tarifa) throws ExcepcionServiciosAlquiler;
		~~~
		2) Clases de equivalencia

		| Número  | Clase de equivalencia (en lenguaje natural o matemático) |   Resultado correcto /incorrecto. |   
		| --- | --- |---|
		| 1  | Parámetros Inválidos |   Resultado incorrecto. |   
		| 2  | Parámetros Correctos y descuento por antelación|   Resultado correcto |   
		| 3  | Parámetros Correctos y descuento por menor de edad|   Resultado correcto |   
		| 4  | Parámetros Correctos y descuento por mayoría de edad|   Resultado correcto |   
		| 5  | Parámetros Correctos, descuento por antelación y menor de edad|   Resultado correcto |   
		| 6  | Parámetros Correctos, descuento por antelación y mayoría de edad|   Resultado correcto |   
		3) Casos de pruebas

		| Número  | Clase de equivalencia  |   Prueba |  Resultado| 
		| --- | --- |---|---|
		| 1  | Parámetros Inválidos |   (-1546666666666666666666666666666666666,2,-1) |   ExcepcionParametrosInvalidos   |
		| 2  | Parámetros Correctos y descuento por antelación|   (666, 21, 30) |  566.1    |   
		| 3  | Parámetros Correctos y descuento por menor de edad|   (1000, 12, 4) |  950|   
		| 4  | Parámetros Correctos y descuento por mayoría de edad|   (10000, 13,69) |  9200 |    
		| 5  | Parámetros Correctos, descuento por antelación y menor de edad|  (5000, 24, 10) |4000 |  
		| 6  | Parámetros Correctos, descuento por antelación y mayoría de edad|  (2000, 25, 77) | 1540   |

		4) Limites de equivalencia

		| Número  | Clase de equivalencia |   Limites |
		| --- | --- |---|
		| 1  | Parámetros Inválidos |   ...(0,0,0) | 
		| 2  | Parámetros Correctos y descuento por antelación|   (1,21,18)  (1,21,65) |  
		| 3  | Parámetros Correctos y descuento por menor de edad|  (1,0,0)  (1,20,17) |  
		| 4  | Parámetros Correctos y descuento por mayoría de edad|   (1,0,66)... |   
		| 5  | Parámetros Correctos, descuento por antelación y menor de edad| (1,21,0)  (1,21,17)  |  
		| 6  | Parámetros Correctos, descuento por antelación y mayoría de edad|  (1,21,66)...  |

		5) Casos de prueba especificos

		| Número  | Clase de equivalencia |   Limites |
		| --- | --- |---|
		| 1  | Parámetros Inválidos |   (0,0,0) (-1546666666666666666666666666666666666,2,-1)| 
		| 2  | Parámetros Correctos y descuento por antelación|   (1,21,18)  (1,21,65)  (666, 21, 30)|  
		| 3  | Parámetros Correctos y descuento por menor de edad|  (1,0,0)  (1,20,17)  (1000, 12, 4) |  
		| 4  | Parámetros Correctos y descuento por mayoría de edad|   (1,0,66) (10000, 13,69) |   
		| 5  | Parámetros Correctos, descuento por antelación y menor de edad| (1,21,0)  (1,21,17)  (5000, 24, 10) |  
		| 6  | Parámetros Correctos, descuento por antelación y mayoría de edad|  (1,21,66) (2000, 25, 77) |

	n) public abstract void registrarItem(Item i) throws ExcepcionServiciosAlquiler;
		- 1) Excepciones
		~~~
		/**
		* @obj Registra el item dado
		* @param i Item a registrar 
		* @throws ExcepcionServiciosAlquiler Si el item ya existe en la base de datos
		*/
		public abstract void registrarItem(Item i) throws ExcepcionServiciosAlquiler;
		~~~
		2) Clases de equivalencia

		| Número  | Clase de equivalencia (en lenguaje natural o matemático) |   Resultado correcto /incorrecto. |   
		| --- | --- |---|
		| 1  | Parámetros Inválidos |   Resultado incorrecto. |   
		| 2  | Parámetros Correctos y descuento por antelación|   Resultado correcto |   
		| 3  | Parámetros Correctos y descuento por menor de edad|   Resultado correcto |   
		| 4  | Parámetros Correctos y descuento por mayoría de edad|   Resultado correcto |   
		| 5  | Parámetros Correctos, descuento por antelación y menor de edad|   Resultado correcto |   
		| 6  | Parámetros Correctos, descuento por antelación y mayoría de edad|   Resultado correcto |   
		3) Casos de pruebas

		| Número  | Clase de equivalencia  |   Prueba |  Resultado| 
		| --- | --- |---|---|
		| 1  | Parámetros Inválidos |   (-1546666666666666666666666666666666666,2,-1) |   ExcepcionParametrosInvalidos   |
		| 2  | Parámetros Correctos y descuento por antelación|   (666, 21, 30) |  566.1    |   
		| 3  | Parámetros Correctos y descuento por menor de edad|   (1000, 12, 4) |  950|   
		| 4  | Parámetros Correctos y descuento por mayoría de edad|   (10000, 13,69) |  9200 |    
		| 5  | Parámetros Correctos, descuento por antelación y menor de edad|  (5000, 24, 10) |4000 |  
		| 6  | Parámetros Correctos, descuento por antelación y mayoría de edad|  (2000, 25, 77) | 1540   |

		4) Limites de equivalencia

		| Número  | Clase de equivalencia |   Limites |
		| --- | --- |---|
		| 1  | Parámetros Inválidos |   ...(0,0,0) | 
		| 2  | Parámetros Correctos y descuento por antelación|   (1,21,18)  (1,21,65) |  
		| 3  | Parámetros Correctos y descuento por menor de edad|  (1,0,0)  (1,20,17) |  
		| 4  | Parámetros Correctos y descuento por mayoría de edad|   (1,0,66)... |   
		| 5  | Parámetros Correctos, descuento por antelación y menor de edad| (1,21,0)  (1,21,17)  |  
		| 6  | Parámetros Correctos, descuento por antelación y mayoría de edad|  (1,21,66)...  |

		5) Casos de prueba especificos

		| Número  | Clase de equivalencia |   Limites |
		| --- | --- |---|
		| 1  | Parámetros Inválidos |   (0,0,0) (-1546666666666666666666666666666666666,2,-1)| 
		| 2  | Parámetros Correctos y descuento por antelación|   (1,21,18)  (1,21,65)  (666, 21, 30)|  
		| 3  | Parámetros Correctos y descuento por menor de edad|  (1,0,0)  (1,20,17)  (1000, 12, 4) |  
		| 4  | Parámetros Correctos y descuento por mayoría de edad|   (1,0,66) (10000, 13,69) |   
		| 5  | Parámetros Correctos, descuento por antelación y menor de edad| (1,21,0)  (1,21,17)  (5000, 24, 10) |  
		| 6  | Parámetros Correctos, descuento por antelación y mayoría de edad|  (1,21,66) (2000, 25, 77) |
		
	ñ) public abstract void vetarCliente(long docu, boolean estado) throws ExcepcionServiciosAlquiler;
		- 1) Excepciones
		~~~
		
	    /**
		* @obj Veta al cliente dado
		* @param docu Documento del cliente
		* @param estado Vetado o no vetado
		* @throws ExcepcionServiciosAlquiler Si el cliente no existe
		*/
	    public abstract void vetarCliente(long docu, boolean estado) throws ExcepcionServiciosAlquiler;
		~~~
		2) Clases de equivalencia

		| Número  | Clase de equivalencia (en lenguaje natural o matemático) |   Resultado correcto /incorrecto. |   
		| --- | --- |---|
		| 1  | Parámetros Inválidos |   Resultado incorrecto. |   
		| 2  | Parámetros Correctos y descuento por antelación|   Resultado correcto |   
		| 3  | Parámetros Correctos y descuento por menor de edad|   Resultado correcto |   
		| 4  | Parámetros Correctos y descuento por mayoría de edad|   Resultado correcto |   
		| 5  | Parámetros Correctos, descuento por antelación y menor de edad|   Resultado correcto |   
		| 6  | Parámetros Correctos, descuento por antelación y mayoría de edad|   Resultado correcto |   
		3) Casos de pruebas

		| Número  | Clase de equivalencia  |   Prueba |  Resultado| 
		| --- | --- |---|---|
		| 1  | Parámetros Inválidos |   (-1546666666666666666666666666666666666,2,-1) |   ExcepcionParametrosInvalidos   |
		| 2  | Parámetros Correctos y descuento por antelación|   (666, 21, 30) |  566.1    |   
		| 3  | Parámetros Correctos y descuento por menor de edad|   (1000, 12, 4) |  950|   
		| 4  | Parámetros Correctos y descuento por mayoría de edad|   (10000, 13,69) |  9200 |    
		| 5  | Parámetros Correctos, descuento por antelación y menor de edad|  (5000, 24, 10) |4000 |  
		| 6  | Parámetros Correctos, descuento por antelación y mayoría de edad|  (2000, 25, 77) | 1540   |

		4) Limites de equivalencia

		| Número  | Clase de equivalencia |   Limites |
		| --- | --- |---|
		| 1  | Parámetros Inválidos |   ...(0,0,0) | 
		| 2  | Parámetros Correctos y descuento por antelación|   (1,21,18)  (1,21,65) |  
		| 3  | Parámetros Correctos y descuento por menor de edad|  (1,0,0)  (1,20,17) |  
		| 4  | Parámetros Correctos y descuento por mayoría de edad|   (1,0,66)... |   
		| 5  | Parámetros Correctos, descuento por antelación y menor de edad| (1,21,0)  (1,21,17)  |  
		| 6  | Parámetros Correctos, descuento por antelación y mayoría de edad|  (1,21,66)...  |

		5) Casos de prueba especificos

		| Número  | Clase de equivalencia |   Limites |
		| --- | --- |---|
		| 1  | Parámetros Inválidos |   (0,0,0) (-1546666666666666666666666666666666666,2,-1)| 
		| 2  | Parámetros Correctos y descuento por antelación|   (1,21,18)  (1,21,65)  (666, 21, 30)|  
		| 3  | Parámetros Correctos y descuento por menor de edad|  (1,0,0)  (1,20,17)  (1000, 12, 4) |  
		| 4  | Parámetros Correctos y descuento por mayoría de edad|   (1,0,66) (10000, 13,69) |   
		| 5  | Parámetros Correctos, descuento por antelación y menor de edad| (1,21,0)  (1,21,17)  (5000, 24, 10) |  
		| 6  | Parámetros Correctos, descuento por antelación y mayoría de edad|  (1,21,66) (2000, 25, 77) |