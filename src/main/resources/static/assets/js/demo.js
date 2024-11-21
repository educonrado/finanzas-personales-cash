"use strict";
// Cicle Chart
Circles.create({
	id:           'task-complete',
	radius:       50,
	value:        80,
	maxValue:     100,
	width:        5,
	text:         function(value){return value + '%';},
	colors:       ['#36a3f7', '#fff'],
	duration:     400,
	wrpClass:     'circles-wrp',
	textClass:    'circles-text',
	styleWrapper: true,
	styleText:    true
})

// Jsvectormap
var world_map = new jsVectorMap({
	selector: "#world-map",
	map: "world",
	zoomOnScroll: false,
	regionStyle: {
		hover: {
			fill: '#435ebe'
		}
	},
	markers: [
		{
			name: 'Indonesia',
			coords: [-6.229728, 106.6894311],
			style: {
				fill: '#435ebe'
			}
		},
		{
			name: 'United States',
			coords: [38.8936708, -77.1546604],
			style: {
				fill: '#28ab55'
			}
		},
		{
			name: 'Russia',
			coords: [55.5807481, 36.825129],
			style: {
				fill: '#f3616d'
			}
		},
		{
			name: 'China',
			coords: [39.9385466, 116.1172735]
		},
		{
			name: 'United Kingdom',
			coords: [51.5285582, -0.2416812]
		},
		{
			name: 'India',
			coords: [26.8851417, 75.6504721]
		},
		{
			name: 'Australia',
			coords: [-35.2813046, 149.124822]
		},
		{
			name: 'Brazil',
			coords: [-22.9140693, -43.5860681]
		},
		{
			name: 'Egypt',
			coords: [26.834955, 26.3823725]
		},
	],
	onRegionTooltipShow(event, tooltip) {
		tooltip.css({ backgroundColor: '#435ebe' })
	}
});

//Chart


var dailySalesChart = document.getElementById('dailySalesChart').getContext('2d');

var myDailySalesChart = new Chart(dailySalesChart, {
	type: 'line',
	data: {
		labels:["January",
		"February",
		"March",
		"April",
		"May",
		"June",
		"July",
		"August",
		"September"],
		datasets:[ {
			label: "Sales Analytics", fill: !0, backgroundColor: "rgba(255,255,255,0.2)", borderColor: "#fff", borderCapStyle: "butt", borderDash: [], borderDashOffset: 0, pointBorderColor: "#fff", pointBackgroundColor: "#fff", pointBorderWidth: 1, pointHoverRadius: 5, pointHoverBackgroundColor: "#fff", pointHoverBorderColor: "#fff", pointHoverBorderWidth: 1, pointRadius: 1, pointHitRadius: 5, data: [65, 59, 80, 81, 56, 55, 40, 35, 30]
		}]
	},
	options : {
		maintainAspectRatio:!1, legend: {
			display: !1
		}
		, animation: {
			easing: "easeInOutBack"
		}
		, scales: {
			yAxes:[ {
				display:!1, ticks: {
					fontColor: "rgba(0,0,0,0.5)", fontStyle: "bold", beginAtZero: !0, maxTicksLimit: 10, padding: 0
				}
				, gridLines: {
					drawTicks: !1, display: !1
				}
			}
			], xAxes:[ {
				display:!1, gridLines: {
					zeroLineColor: "transparent"
				}
				, ticks: {
					padding: -20, fontColor: "rgba(255,255,255,0.2)", fontStyle: "bold"
				}
			}
			]
		}
	}
});

$("#activeUsersChart").sparkline([112,109,120,107,110,85,87,90,102,109,120,99,110,85,87,94], {
	type: 'bar',
	height: '100',
	barWidth: 9,
	barSpacing: 10,
	barColor: 'rgba(255,255,255,.3)'
});
