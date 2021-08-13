window.addEventListener('load', function(e){
  console.log("script.js loaded");
  init();
});

function init(){

console.log('* in init *');
loadFighters();

document.fighterForm.add.addEventListener('click', function(e){
  e.preventDefault();
  let f = document.fighterForm;
  
  let newFighter = {
    name: f.name.value,
    head: {
      id: f.head.value},
    torso: {
      id: f.torso.value},
    legs: {
      id: f.legs.value}
  };

  if(f.stat.value === 'strength'){
    newFighter.strength = 70;
    newFighter.speed = 35;
    newFighter.intelligence = 35;
  }
  else if(f.stat.value === 'speed'){
    newFighter.speed = 70;
    newFighter.strength = 35;
    newFighter.intelligence = 35;
  }
  else if(f.stat.value === 'intelligence'){
    newFighter.strength = 35;
    newFighter.speed = 35;
    newFighter.intelligence = 70;
  }

  console.log(newFighter);
  newFighter.health = 100;
  createFighter(newFighter);
});

// document.row.info.addEventListener('click', function(event) {
//   event.preventDefault();
//   var fighterId = document.row.info.fighterId.value;
//   console.log(fighterId);
//   if (!isNaN(fighterId) && fighterId > 0) {
//     getFighter(fighterId);
//   }
// });
}

function loadFighters(){
  let xhr = new XMLHttpRequest();

  xhr.open('GET', 'api/fighters');

  xhr.onreadystatechange = function(){
    if (xhr.readyState === 4){
      if (xhr.status === 200){
        // location.reload();
        console.log('Response successful');
        // console.log(xhr.responseText);
        let data = JSON.parse(xhr.responseText)
        displayFighters(data);
      }
    else{
      console.log('Response failed');
    }
  }
};
xhr.send();
};

function getFighter(fighterId) {
	let xhr = new XMLHttpRequest();
	xhr.open('GET', 'api/fighters/' + fighterId);
	xhr.onreadystatechange = function() {
		if (xhr.readyState === 4) {
			if (xhr.status === 200) {
				let fighter = JSON.parse(xhr.responseText);
				displayFighter(fighter);
			}
			else {
				displayError('Fighter not found');
			}
		}
	};
	xhr.send();
}

function displayFighter(fighter) {
	var dataDiv = document.getElementById('fighterData');
  let form = document.createElement('form');
  // form.id = 'updateFighterForm';
  form.name = 'updateFighterForm';
  document.body.appendChild(form);
	dataDiv.textContent = '';

  // document.updateFighterForm.submit.addEventListener('click', function(e){
  //   e.preventDefault();

	  let h1 = document.createElement('h1');
	  h1.textContent = fighter.name;
	  dataDiv.appendChild(h1);
    let input = document.createElement('input');
    input.type = 'text';
    input.id = 'name';
	  form.appendChild(input);
    h1.appendChild(input);

    let ul = document.createElement('ul');
    let li = document.createElement('li');
    li.textContent = 'Strength = ' + fighter.strength;
    ul.appendChild(li);
    let input1 = document.createElement('input');
    input1.type = 'text';
    input1.id = 'strength';
    form.appendChild(input1);
    li.appendChild(input1);

    li = document.createElement('li');
    li.textContent = 'Speed = ' + fighter.speed;
    ul.appendChild(li);
    let input2 = document.createElement('input');
    input1.type = 'text';
    input1.id = 'speed';
    form.appendChild(input2);
    li.appendChild(input2);

    li = document.createElement('li');
    li.textContent = 'Intelligence = '+fighter.intelligence;
    ul.appendChild(li);
    let input3 = document.createElement('input');
    input3.type = 'text';
    input3.id = 'intelligence';
    form.appendChild(input3);
    li.appendChild(input3);

    li = document.createElement('li');
    li.textContent = 'Max Health = '+fighter.health;
    ul.appendChild(li);
    let input4 = document.createElement('input');
    input4.type = 'text';
    input4.id = 'health';
    form.appendChild(input4);
    li.appendChild(input4);

	  dataDiv.appendChild(ul);

    var submit = document.createElement('input');
		submit.name = 'submit'; // assign a name attribute
		submit.type = 'submit'; // assign a type attribute
		submit.value = 'Submit Form'; // assign a value attribute

    form.appendChild(submit);
	
    var del = document.createElement('input');
		del.name = 'deleted'; // assign a name attribute
		del.type = 'submit'; // assign a type attribute
		del.value = 'Delete Fighter'; // assign a value attribute

    form.appendChild(del);
  

  document.updateFighterForm.submit.addEventListener('click', function(e){
    e.preventDefault();
    // updateFighter(fighter); 
    let f = document.getElementsByName('updateFighterForm')
    fighter = {
      name: form.name.value,
      head: {
        id: fighter.head.id},
      torso: {
        id: fighter.torso.id},
      legs: {
        id: fighter.legs.id}
    };
    var strength = document.getElementById('strength');
    var str = parseInt(strength);
    fighter.strength = str;

    var speed = document.getElementById('speed');
    var spd = parseInt(speed);
    fighter.speed = spd;

    var intelligence = document.getElementById('intelligence');
    var intl = parseInt(intelligence);
    fighter.intelligence = intl;

    var health = document.getElementById('health');
    var hlth = parseInt(health);
    fighter.health = hlth;
    
    var fighterId = fighter.id;
    updateFighter(fighterId, fighter); 
  });

}

function displayFighters(fighters){
  // location.reload();
  console.log('in display fighters');
  let tBody = document.getElementById('tableBody');
  tBody.textContent = '';

  for(const fighter of fighters){

    let tr = document.createElement('tr');
    let td = document.createElement('td');
    td.textContent = fighter.name;
    tr.appendChild(td);
    
    // tr = document.createElement('tr');
    td1 = document.createElement('td');
    td1.textContent = fighter.strength;
    tr.appendChild(td1);
    
    // tr = document.createElement('tr');
    td2 = document.createElement('td');
    td2.textContent = fighter.speed;
    tr.appendChild(td2);
  
    // tr = document.createElement('tr');
    td3 = document.createElement('td');
    td3.textContent = fighter.intelligence;
    tr.appendChild(td3);

    // tr = document.createElement('tr');
    td4 = document.createElement('td');
    td4.textContent = fighter.health;
    tr.appendChild(td4);

    tBody.appendChild(tr);

    tr.addEventListener('click', function(event) {
      event.preventDefault();
      var fighterId = fighter.id;
      console.log(fighterId);
      if (!isNaN(fighterId) && fighterId > 0) {
        getFighter(fighterId);
      }
    });

    console.log('at end of display fighters');
  }
}

function createFighter(fighter) {
	let xhr = new XMLHttpRequest();
	xhr.open('POST', 'api/fighters', true);
  xhr.setRequestHeader("Content-type", "application/json");

	xhr.onreadystatechange = function() {
		
    if (xhr.readyState === 4) {
			if (xhr.status === 201 || xhr.status === 200) {
				let newFighter = JSON.parse(xhr.responseText);
				// displayFighters(newFighter);
        loadFighters();
			}
			else {
				displayError('Error creating fighter: ' + xhr.status);
			}
		}
	};
	// xhr.setRequestHeader("Content-type", "application/json"); 
	let fighterJson = JSON.stringify(fighter);
	xhr.send(fighterJson);
}

function updateFighter(fighterId, fighter) {
	let xhr = new XMLHttpRequest();
	xhr.open('POST', 'api/fighters/' + fighterId);
  xhr.setRequestHeader("Content-type", "application/json");

	xhr.onreadystatechange = function() {
		
    if (xhr.readyState === 4) {
			if (xhr.status === 201 || xhr.status === 200) {
        var data = JSON.parse(xhr.responseText);
        console.log(data);
        loadFighters();
			}
			else {
				displayError('Error updating fighter: ' + xhr.status);
			}
		}
	}; 
	let fighterJson = JSON.stringify(fighter);
	xhr.send(fighterJson);
}

function displayError(msg) {
	var dataDiv = document.getElementById('fighterData');
	dataDiv.textContent = msg;
}