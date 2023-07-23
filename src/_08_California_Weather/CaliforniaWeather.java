package _08_California_Weather;

import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/*
 * OBJECTIVE:
 * 1. Create a program that allows the user to search for the weather
 * conditions of a given city in California. Use the example program below
 * and the Utilities class inside this project to get the temperature data
 * from a day in December 2020.
 * Example: User: Encinitas
 *          Program: Encinitas is Overcast with a tempeature of 59.01 �F
 * 
 * 2. Create a way for the user to specify the weather condition and then
 * list the cities that have those conditions.
 * Example: User: Mostly Cloudy
 *          Program: Long Beach, Pomona, Oceanside, ...
 * 
 * 3. Create a way for the user to enter a minimum and maximum temperature
 * and then list the cities that have temperatures within that range
 * Example: User: minimum temperature �F = 65.0, max temperature �F = 70.0
 *          Program: Fortana, Glendale, Escondido, Del Mar, ...
 * 
 * EXTRA:
 * Feel free to add pictures for specific weather conditions or a thermometer
 * for the temperature. Also If you want your program to get the current day's
 * temperature, you can get a free API key at: https://openweathermap.org/api
 */

public class CaliforniaWeather implements ActionListener {
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JButton citySearch = new JButton();
	JButton conditionSearch = new JButton();
	JButton rangeSearch = new JButton();
	HashMap<String, WeatherData> weatherData = Utilities.getWeatherData();

	void start() {
		frame.add(panel);
		panel.add(citySearch);
		panel.add(conditionSearch);
		panel.add(rangeSearch);
		citySearch.addActionListener(this);
		conditionSearch.addActionListener(this);
		rangeSearch.addActionListener(this);
		frame.setTitle("Weather Finder");
		citySearch.setText("Search By City");
		conditionSearch.setText("Search By Weather Condition");
		rangeSearch.setText("Search By Tempature Range");
		frame.setVisible(true);
		frame.pack();

		// All city keys have the first letter capitalized of each word

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		Object buttonPressed = e.getSource();
		if (buttonPressed == citySearch) {
			String input = JOptionPane
					.showInputDialog("Type the name of the city you would like to view the weather for.");
			String cityName = Utilities.capitalizeWords(input);
			WeatherData datum = weatherData.get(cityName);

			if (datum == null) {
				System.out.println("Unable to find weather data for: " + cityName);
			} else {
				System.out.println(cityName + " is " + datum.weatherSummary + " with a temperature of "
						+ datum.temperatureF + " F");
			}
		} else if (buttonPressed == conditionSearch) {
			String input = JOptionPane.showInputDialog("Type the weather condition you would like to find.");
			String weatherCondition = Utilities.capitalizeWords(input);
			int cycle = 0;
			ArrayList<String> cityList = new ArrayList<>();
			for (String name : Utilities.getWeatherData().keySet()) {

				if (weatherData.get(name).weatherSummary.equals(weatherCondition)) {

					// find how to access city name
					cityList.add(name);
					cycle++;
					if (cycle == 10) {
						cityList.add("\n");
						cycle = 0;
					}
				}
			}
			JOptionPane.showMessageDialog(null,
					"Cities With the Weather Condition (" + weatherCondition + "): " + cityList);
		} else if (buttonPressed == rangeSearch) {
			int cycle = 0;
			ArrayList<String> cityList = new ArrayList<>();
			String lowTemp = JOptionPane
					.showInputDialog("Type the lowest tempature (farenheit) you would like to see.");
			int low = Integer.parseInt(lowTemp);
			String highTemp = JOptionPane
					.showInputDialog("Now type the highest tempature (farenheit) you would like to see.");
			int high = Integer.parseInt(highTemp);
			// turn to ints
			for (String name : Utilities.getWeatherData().keySet()) {

				double tempature = weatherData.get(name).temperatureF;
				if (low <= tempature && tempature <= high) {
					cityList.add(name);
					cycle++;
					if (cycle == 10) {
						cityList.add("\n");
						cycle = 0;
					}
				}

				// find how to access city name

			}
			JOptionPane.showMessageDialog(null,
					"Cities With the Tempature Range: " + cityList);
		}
	}
}
