// Home Section  
var hamburgerBtn = document.querySelector('.main-navbar .hamburger-btn'); 
var navList = document.querySelector('.main-navbar .nav-list'); 
var navListItems = document.querySelectorAll('.nav-list li a'); 

hamburgerBtn.addEventListener('click', activeClass);

function activeClass(){ 
    hamburgerBtn.classList.toggle('active'); 
    navList.classList.toggle('active'); 
}

// Close the nav menu when clicking on a link
for(var i = 0; i < navListItems.length; i++){ 
    navListItems[i].addEventListener('click', listItemClicked); 
}

function listItemClicked(){ 
    hamburgerBtn.classList.remove('active'); 
    navList.classList.remove('active'); 
}

// Code For Navbar Active State 
var homeSection = document.querySelector('.home');  // Use class 'home', not ID
window.addEventListener('scroll', pageScrollFunction); 
window.addEventListener('load', pageScrollFunction); 

function pageScrollFunction(){ 
    if(window.scrollY > 150){ 
        homeSection.classList.add('active'); 
    } else { 
        homeSection.classList.remove('active'); 
    } 
}
