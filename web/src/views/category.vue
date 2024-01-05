<template>
    <div class="login-container1">
        <h2>GetCategory</h2>
        <form @submit.prevent="get">
            <div class="form-group">
                <label for="CategoryId">CategoryId:</label>
                <input type="OrderId" id="CategoryId" v-model="id" required>
            </div>

            <button type="getOrder">get</button>
        </form>
        <table id="ordersTable">
            <thead>
                <tr>
                    <th>Category ID</th>
                    <th>details</th>
                    <th>name</th>
                    <th>price</th>
                </tr>
            </thead>
            <tbody>
                <!-- Orders will be dynamically added here -->
            </tbody>
        </table>
    </div>
    <div class="login-container">
        <h2>CreateCategory</h2>
        <form @submit.prevent="login">
            <div class="form-group">
                <label for="userId">id:</label>
                <input type="categoryId" id="username" v-model="form.id" required>
            </div>
            <div class="form-group">
                <label for="categoryId">name:</label>
                <input type="categoryId" id="categoryId" v-model="form.name" required>
            </div>
            <div class="form-group">
                <label for="summoney">level:</label>
                <input type="summoney" id="summoney" v-model="form.level" required>
            </div>
            <div class="form-group">
                <label for="summoney">detail:</label>
                <input type="summoney" id="detail" v-model="form.detail" required>
            </div>
            <div class="form-group">
                <label for="summoney">price:</label>
                <input type="summoney" id="price" v-model="form.price" required>
            </div>
            <div class="form-group">
                <label for="summoney">OrderId:</label>
                <input type="summoney" id="OrderId" v-model="form.order_number" required>
            </div>

            <button type="submit">Create</button>
        </form>
    </div>
    <div class="login-container1">
        <h2>List Category</h2>
        <form @submit.prevent="list">
            <div class="form-group">
                <label for="Name">Name:</label>
                <input type="OrderId" id="CategoryId" v-model="name" required>
            </div>
            <div class="form-group">
                <label for="Level">Level:</label>
                <input type="OrderId" id="CategoryId" v-model="level" required>
            </div>

            <button type="getOrder">get</button>
        </form>
        <table id="ordersTable2">
            <thead>
                <tr>
                    <th>Category ID</th>
                    <th>levels</th>
                    <th>name</th>
                </tr>
            </thead>
            <tbody>
                <!-- Orders will be dynamically added here -->
            </tbody>
        </table>
    </div>
</template>
  
<script>
import axios from 'axios';

export default {
    data() {
        return {

            name: '',
            level: '',

            id: '',

            form: {
                "id": '',
                "name": '',
                "level": '',
                "detail":'',
                "price":'',
                "order_number":''


            },

            userdata: {
            }
        };
    },
    methods: {
        login() {

            axios.post('http://localhost:18082/category', this.form)
                .then(function (response) {
                    console.log(response);


                })
                .catch(function (error) {
                    console.log(error);
                });



        },
        get() {
            axios.get('http://localhost:18082/category/' + this.id)
                .then(function (response) {
                    console.log(response);
                    var tbody = document.getElementById('ordersTable').getElementsByTagName('tbody')[0];
                    var row = tbody.insertRow();
                    row.insertCell(0).textContent = response.data.id;
                    row.insertCell(1).textContent = response.data.detail;
                    row.insertCell(2).textContent = response.data.name;
                    row.insertCell(3).textContent = '$' + response.data.price;
                })
                .catch(function (error) {
                    console.log(error);
                });
        },
        list() {

            axios.get('http://localhost:18082/category', {
                params: {
                    level: this.level,
                    name: this.name
                }
            })
                .then(function (response) {
                    console.log(response);
                    var tbody = document.getElementById('ordersTable2').getElementsByTagName('tbody')[0];
                    for (var i = 0; i < response.data.length; i++) {
                        var row = tbody.insertRow();
                        row.insertCell(0).textContent = response.data[i].id;
                        row.insertCell(1).textContent = response.data[i].level;
                        row.insertCell(2).textContent = response.data[i].name;
                        
                    }

                })
                .catch(function (error) {
                    console.log(error);
                });
            // Perform login logic here, e.g., send a request to the server
            console.log('Logging in with:', this.username, this.password);



        }
    }
};
</script>
  
<style scoped>
.login-container {
    max-width: 300px;
    margin: auto;
    padding: 20px;
    border: 1px solid #ccc;
    border-radius: 5px;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
}

.login-container1 {
    max-width: 400px;
    margin: auto;
    padding: 20px;
    border: 1px solid #ccc;
    border-radius: 5px;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
}

.form-group {
    margin-bottom: 15px;
}

label {
    display: block;
    margin-bottom: 5px;
}

input {
    width: 100%;
    padding: 8px;
    box-sizing: border-box;
    border: 1px solid #ccc;
    border-radius: 3px;
    outline: none;
}

button {
    background-color: #4caf50;
    color: white;
    padding: 10px;
    border: none;
    border-radius: 3px;
    cursor: pointer;
}
</style>
  