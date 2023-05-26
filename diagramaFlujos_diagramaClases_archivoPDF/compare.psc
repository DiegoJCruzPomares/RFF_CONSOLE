Algoritmo compare
	Leer fileName
	tempfolder<-fileName
	Si tempfolder = 0 Entonces
		Escribir This folder is empty, it does not exist, or could not find repeated files, please try another one
		Escribir IllegalArgumentException
	SiNo
		Escribir tempfolder
	Fin Si
FinAlgoritmo
