<template>
    <div class="login-container">
        <h2>AddOrder</h2>
        <form @submit.prevent="login">
            <div class="form-group">
                <label for="userId">userId:</label>
                <input type="categoryId" id="username" v-model="form.userId" required>
            </div>
            <div class="form-group">
                <label for="categoryId">categoryId:</label>
                <input type="categoryId" id="categoryId" v-model="form.categoryId" required>
            </div>
            <div class="form-group">
                <label for="summoney">summoney:</label>
                <input type="summoney" id="summoney" v-model="form.summoney" required>
            </div>

            <button type="submit">Add</button>
        </form>
    </div>
    <div class="login-container">
        <h2>GetOrder</h2>
        <form @submit.prevent="get">
            <div class="form-group">
                <label for="OrderId">OrderId:</label>
                <input type="OrderId" id="OrderId" v-model="id" required>
            </div>

            <button type="getOrder">get</button>
        </form>
        <table id="ordersTable">
        <thead>
            <tr>
                <th>Order ID</th>
                <th>Date and Time</th>
                <th>Sum of Money</th>
                <th>User ID</th>
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

            id: '',

            form: {
                "userId": '',
                "categoryId": '',
                "summoney": ''

            },

            userdata: {
            }
        };
    },
    methods: {
        login() {

            axios.post('http://localhost:18080/order/addOrder', this.form)
                .then(function (response) {
                    console.log(response);
                    if (!response.data) {
                        this.userdata.id = response.data.id;
                        this.userdata.name = response.data.name;
                    }
                })
                .catch(function (error) {
                    console.log(error);
                });
            // Perform login logic here, e.g., send a request to the server
            console.log('Logging in with:', this.username, this.password);



        },
        get() {
            axios.get('http://localhost:18080/order/getOrder/' + this.id)
                .then(function (response) {
                    console.log(response);
                    var tbody = document.getElementById('ordersTable').getElementsByTagName('tbody')[0];
                    var row = tbody.insertRow();
                    row.insertCell(0).textContent = response.data.id;
                    row.insertCell(1).textContent = response.data.datetime;
                    row.insertCell(2).textContent = '$' + response.data.summoney;
                    row.insertCell(3).textContent = response.data.userId;
                })
                .catch(function (error) {
                    console.log(error);
                });
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
  