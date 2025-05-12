// Import the functions you need from the SDKs you need
import { initializeApp } from "firebase/app";
import { getAnalytics } from "firebase/analytics";

import { getAuth, GoogleAuthProvider } from "firebase/auth";
import { getFirestore } from "firebase/firestore";
// TODO: Add SDKs for Firebase products that you want to use
// https://firebase.google.com/docs/web/setup#available-libraries

// Your web app's Firebase configuration
// For Firebase JS SDK v7.20.0 and later, measurementId is optional
const firebaseConfig = {
  apiKey: "AIzaSyDXaFRQcKi_WH6lufDCUPzuD2hmgr7poZ0",
  authDomain: "first-react-ca602.firebaseapp.com",
  projectId: "first-react-ca602",
  storageBucket: "first-react-ca602.firebasestorage.app",
  messagingSenderId: "631377644728",
  appId: "1:631377644728:web:6bd3e474f8cf47c8e5784d",
  measurementId: "G-LC4LDJPNZJ"
};

// Initialize Firebase
const app = initializeApp(firebaseConfig);
const analytics = getAnalytics(app);

const auth = getAuth(app);
const provider = new GoogleAuthProvider();
const db = getFirestore(app);

export { auth, provider, db };