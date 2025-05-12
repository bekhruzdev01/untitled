import React from "react";
import { signInWithPopup } from "firebase/auth";
import { auth, provider } from "../firebase";

function GoogleLogin() {
  const handleGoogleLogin = async () => {
    try {
      const result = await signInWithPopup(auth, provider);
      const user = result.user;
      alert(`Xush kelibsiz, ${user.displayName}`);
      console.log("Google foydalanuvchi:", user);
    } catch (error) {
      console.error("Google login xatolik:", error);
      alert("Google bilan tizimga kirishda xatolik!");
    }
  };

  return (
    <div style={{ padding: "20px" }}>
      <h2>Google bilan kirish</h2>
      <button onClick={handleGoogleLogin}>Google bilan kirish</button>
    </div>
  );
}

export default GoogleLogin;
