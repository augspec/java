/**
 * 
 */
$(document).ready(function(){
	changeStockData();
	chainMatchPrice();
	setInterval(() => {
		changeStockData();
	}, 5000);
});

function changeStockData() {
	changePrice('sell', 1);
	changePrice('sell', 2);
	changePrice('sell', 3);
	changePrice('buy', 1);
	changePrice('buy', 2);
	changePrice('buy', 3);

	chainTotalPrice(1);
	chainTotalPrice(2);
	chainTotalPrice(3);
}

function changePrice(act, index) {
	$('.' + act + '_price_' + index).each(function() {
		var weight = $(this).closest('tr').find('.' + act + '_weigth_' + index);
		changeStockColor($(this), weight);
	});
}

function changeStockColor(stock, weightElement) {
	var __max = stock.closest('tr').find('.max_price').text();
	var max = parseFloat(__max, 10);
	var __min = stock.closest('tr').find('.min_price').text();
	var min = parseFloat(__min, 10);
	var __tc = stock.closest('tr').find('.tc_price').text();
	var tc = parseFloat(__tc, 10);
	
	var current = generateNewStockValue(stock);
	var weightValue = generateWeightValue();
	
	stock.text(current);
	weightElement.text(weightValue);
	
	if (current == max) {
		stock.css('color', '#F791D2');
		weightElement.css('color',
				'#F791D2');
	}
	if (current == min) {
		stock.css('color', '#1BAFE2');
		weightElement.css('color',
				'#1BAFE2');
	}
	if (current == tc) {
		stock.css('color', '#FFFF00');
		weightElement.css('color',
				'#FFFF00');
	}
	if (current < tc && current > min) {
		stock.css('color', '#49AC32');
		weightElement.css('color',
				'#49AC32');
	}
	if (current > tc && current < max) {
		stock.css('color', 'red');
		weightElement.css('color',
				'red');
	}
}

function chainMatchPrice() {
	$('.match_price').each(
			function() {
				var __max = $(this).closest('tr').find('.max_price').text();
				var max = parseFloat(__max, 10);
				var __min = $(this).closest('tr').find('.min_price').text();
				var min = parseFloat(__min, 10);
				var __tc = $(this).closest('tr').find('.tc_price').text();
				var tc = parseFloat(__tc, 10);
				var __current = $(this).text();
				var current = parseFloat(__current, 10);
				if (current == max) {
					$(this).css('color', '#F791D2');
					$(this).closest('tr').find('.match_weight').css('color',
							'#F791D2');
					$(this).closest('tr').find('.match_value').css('color',
							'#0BFF09');
				}
				if (current == min) {
					$(this).css('color', '#1BAFE2');
					$(this).closest('tr').find('.match_weight').css('color',
							'#1BAFE2');
					$(this).closest('tr').find('.match_value').css('color',
							'#1BAFE2');
				}
				if (current == tc) {
					$(this).css('color', '#FFFF00');
					$(this).closest('tr').find('.match_weight').css('color',
							'#FFFF00');
					$(this).closest('tr').find('.match_value').css('color',
							'#FFFF00');
				}
				if (current < tc) {
					$(this).css('color', 'red');
					$(this).closest('tr').find('.match_weight').css('color',
							'red');
					$(this).closest('tr').find('.match_value').css('color',
							'red');
				}
				if (current > tc) {
					$(this).css('color', '#0BFF09');
					$(this).closest('tr').find('.match_weight').css('color',
							'#0BFF09');
					$(this).closest('tr').find('.match_value').css('color',
							'#0BFF09');
				}
			});
}

function chainTotalPrice(index) {
	$('.total_price_' + index).each(function() {
		var __max = $(this).closest('tr').find('.max_price').text();
		var max = parseFloat(__max, 10);
		var __min = $(this).closest('tr').find('.min_price').text();
		var min = parseFloat(__min, 10);
		var __tc = $(this).closest('tr').find('.tc_price').text();
		var tc = parseFloat(__tc, 10);
		var __total_1 = $(this).text();
		var current = parseFloat(__total_1, 10);
		if (current == max) {
			$(this).css('color', '#F791D2');
		}
		if (current == min) {
			$(this).css('color', '#1BAFE2');
		}
		if (current == tc) {
			$(this).css('color', '#FFFF00');
		}
		if (current < tc && current > min) {
			$(this).css('color', 'red');
		}
		if (current > tc && current < max) {
			$(this).css('color', '#0BFF09');
		}
	});
}

function generateNewStockValue(element){
	var __max = element.closest('tr').find('.max_price').text();
	var max = parseFloat(__max, 10);
	var __min = element.closest('tr').find('.min_price').text();
	var min = parseFloat(__min, 10);
	var __current = element.text();
	var current = parseFloat(__current, 10);
	
	var ran = Math.random() * 100;
	var newValue = current;
	if (ran > 30) {
		if (ran < 70 && current < max) {
			newValue = current + 0.1;
		} else if (ran > 50 && current > min) {
			newValue = current - 0.1;
		}
	}
	return newValue.toFixed(1);
}

function generateWeightValue(){
	var ran = Math.random() * 10000;
	return Math.round(ran);
}