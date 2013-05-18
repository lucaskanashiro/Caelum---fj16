import java.util.Calendar;
import java.util.List;

public class CandlestickFactory {
	
	public Candlestick constroiCandleParaData(Calendar data, List<Negocio> negocios) {
		
		double maximo;
		double minimo;
		double volume;
		double abertura;
		double fechamento;
		
		if(negocios.isEmpty()){
			
			maximo = 0.0;
			minimo = 0.0;
			volume = 0.0;
			abertura = 0.0;
			fechamento = 0.0;
			
			return new Candlestick(abertura, fechamento, minimo, maximo,volume, data);
		}
		
		maximo = negocios.get(0).getPreco();
		minimo = negocios.get(0).getPreco();
		volume = 0.0;
		
		for (Negocio negocio : negocios) {
			volume += negocio.getVolume();		
			if (negocio.getPreco() > maximo) {
				maximo = negocio.getPreco();
			} else if (negocio.getPreco() < minimo) {
				minimo = negocio.getPreco();
			}			
		}
	
		abertura = negocios.get(0).getPreco();
		fechamento = negocios.get(negocios.size()-1).getPreco();
		
		return new Candlestick(abertura, fechamento, minimo, maximo,volume, data);
	
	}

}
