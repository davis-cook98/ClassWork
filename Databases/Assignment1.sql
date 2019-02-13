#Davis Cook HW 1

# Number 1
select first_name, last_name
from sakila.actor
where first_name = "Penelope";

# Number 2
select first_name, last_name
from actor 
join film_actor on actor.actor_id = film_actor.actor_id
join film on film_actor.film_id = film.film_id 
and film.title = "ZOOLANDER FICTION";

# Number 3
select title
from actor 
join film_actor on actor.actor_id = film_actor.actor_id
join film on film_actor.film_id = film.film_id 
and actor.first_name = "JENNIFER"
and actor.last_name = "Davis";

# Number 4
select title
from rental
join inventory on rental.inventory_id = inventory.inventory_id
join film on film.film_id = inventory.film_id
where rental.return_date is null
and rental.customer_id = 11;

# Number 5
select title
from film_category
join film on film.film_id = film_category.film_id
where film_category.category_id = 2;

# Number 6
select amount, payment_date
from payment
join rental on payment.rental_id = rental.rental_id
join inventory on rental.inventory_id = inventory.inventory_id
join film on film.film_id = inventory.film_id
and title = "CLOSER BANG"
and payment.customer_id = 95;

# Number 7
select staff.first_name, staff.last_name
from staff
join rental on rental.staff_id = staff.staff_id
join inventory on inventory.inventory_id = rental.inventory_id
join film on film.film_id = inventory.film_id
join customer on rental.customer_id = customer.customer_id
and film.title = "CHAINSAW UPTOWN"
and customer.first_name = "MARIE"
and customer.last_name = "TURNER";