# Using MongoDB Atlas

MongoDB Atlas is a cloud MongoDB server. It has a free-tier plan.

When you sign up and get a MongoDB instance at https://www.mongodb.com/cloud/atlas/register (Free tier available). 

# Install MongoDB locally
## Ubuntu 22.04 LTS
Installation (Use Ubuntu 22.04 LTS as an example. Note that Windows Linux Subsystem is not compatible with MongoDB!)

Reference: Install MongoDB Community Edition on Ubuntu — MongoDB Manual

sudo apt-get install gnupg

sudo apt install curl

curl -fsSL https://pgp.mongodb.com/server-6.0.asc | \
sudo gpg -o /usr/share/keyrings/mongodb-server-6.0.gpg \
--dearmor

echo "deb [ arch=amd64,arm64 signed-by=/usr/share/keyrings/mongodb-server-6.0.gpg ] https://repo.mongodb.org/apt/ubuntu jammy/mongodb-org/6.0 multiverse" | sudo tee /etc/apt/sources.list.d/mongodb-org-6.0.list

sudo apt-get update

sudo apt-get install -y mongodb-org

You can start the MongoDB software by sudo systemctl start mongod. You can start the MongoDB on system boot by sudo systemctl enable mongod. You can check the MongoDB status by sudo systemctl status mongod.

Let's create an admin user. db.createUser({user: "admin", "pwd": passwordPrompt(), roles: ["root"]});

Give a secure password.

Now, let's create the user for our DB. db.createUser({user: "csc207", "pwd": passwordPrompt(), roles: [{ role: 'readWrite', db: 'csc207' }]});

Type ctrl+c to exit the mongosh.

## MacOS
Installation
Please read this to install MongoDB on your local machine: https://www.mongodb.com/docs/manual/tutorial/install-mongodb-on-os-x/

You need to have `brew` installed on your Mac.

You can verify if MongoDB is installed and running by mongosh.

Create User for CSC207
When you make sure that MongoDB is running, type mongosh. Switch to the admin collection by use admin;

Let's create an admin user first before we turn on authedication. db.createUser({user: "admin", "pwd": passwordPrompt(), roles: ["root"]});

Give a secure password.

Now, let's create the user for our DB. db.createUser({user: "csc207", "pwd": passwordPrompt(), roles: [{ role: 'readWrite', db: 'csc207' }]});

Type ctrl+c to exit the mongosh.

Restart MongoDB by brew services restart mongodb-community@6.0

Enter MongoDB shell by mongosh. Switch to admin by use admin;

Auth yourself with the admin account by: db.auth(username, password);