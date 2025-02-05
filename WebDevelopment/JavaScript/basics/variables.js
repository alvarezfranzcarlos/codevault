// Using const, let, var with a real-world example
(function() {
    "use strict";

    const MAX_USERS = 100; // Immutable global variable
    let activeUsers = 0; // Mutable scoped variable
    var deprecatedVar = "This is an outdated declaration"; // Avoid using var

    function registerUser() {
        if (activeUsers < MAX_USERS) {
            activeUsers++;
            console.log(`User registered! Active users: ${activeUsers}`);
        } else {
            console.log("User limit reached!");
        }
    }

    registerUser();
})();
