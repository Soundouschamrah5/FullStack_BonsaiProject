create index dish_idx on dish(dishname);
create index acc_idx on account(accountlastname, accountfirstname);
create index order_idx on foodOrder(ordertotalprice);

--View--
create view vwAUIers as 
(select * from account
where accountauier = true);

--Functions--

create or replace function changePass(accId int, newpass varchar)
returns boolean 
language plpgsql
as $$
begin
	update account
	set accountpass = newpass
	where accountid = accId;
return(true);
end;
$$

create or replace function addSupplier(newid int, newName varchar(10), newContact varchar(20), newPhone char(10))
returns boolean 
language plpgsql
as $$
begin
	insert into supplier 
	values(newid, newName, newContact, newPhone);
return (true);
end;
$$;

--Triggers--

--Trigger to check if a password is 'weak' or not--
create or replace function checkPass() returns trigger
language plpgsql
as $$
begin 
	if account.accountPass like 'password', '123456', 'password123', '123456789', '000000000'
	then
	raise notice 'This password is considered weak, please change it';
	end if;
end;
$$;

create trigger check_pass after insert on account for each row
execute function checkPass();

--Trigger to compute the total price of the order any time the subtotal price is changed.--

create or replace function computeTotalPrice()
returns trigger 
language plpgsql
as $$ 
declare new_subtotal numeric(8,2);
begin	
	new_subtotal = (select sum(subtotal) from orderDishes where orderid = new.orderId) + new.subtotal;
	update foodOrder
	set ordertotalprice = ordertotalprice + new_subtotal + new_subtotal * 0.2
	where orderid = new.orderId;
	--The 20% (0.2) is equivalent to the value added tax in Morocco--
return (true);
end;
$$;

--Trigger to update the subtotal to its computed value--
create or replace function computeSubTotal() returns trigger
language plpgsql 
as $$ 
begin
	update orderDishes
	set ordersubtotal = orderquantity * (select dishprice from dish where dishid = new.dishId);
end; 
$$;

create trigger compute_sub_total after insert on orderDishes for each row execute function computeSubTotal();



	





