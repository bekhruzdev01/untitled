import { useState } from "react"
import { Link, useNavigate } from "react-router-dom"
import { toast } from "react-toastify"

function Last() {
    const [name, setName] = useState('')
    const [surname, setSurname] = useState('')
    const [email, setEmail] = useState('')
    const [password, setPassword] = useState('')
    const [prePassword, setPrePassword] = useState('')
    const navigate = useNavigate()

    const validate = () => {
        if (name.trim().length < 3) {
            return toast.error("Ism bo'lishi shart!")
        }
        if (surname.trim().length < 5) {
            return toast.error("Familiya bo'lishi shart!")
        }
        if (!email.endsWith("@gmail.com") || email.trim().length < 13) {
            return toast.error("Emailda xatolik iltimos qayta urinib ko'ring")
        }
        if (password.length < 6) {
            return toast.error("Parol kamida 6ta belgidan iborat bo'lishi shart!")
        }
        if (password != prePassword) {
            return toast.error("Parol va tasdiqlash paroli teng bo'lishi shart!")
        }
        toast.success("Muvaffaqiyattli tekshiruvdan o'tdingiz")
        navigate("/")
    }

    return (
        <div className="container">
            Ikkinchi sahifa
            <Link className="btn btn-primary" to="/">Birinchi sahifaga o'tish</Link>
            <div className="w-100 mt-3 d-flex align-items-center justify-content-center">
                <div className="w-50 shadow p-4">
                    <h3 className="text-center text-primary">Tekshirish</h3>
                    <input
                        value={name}
                        onChange={e => setName(e.target.value)}
                        type={"text"}
                        className="form-control mt-2"
                        placeholder="Ismingizni kiriting" />
                    <input
                        value={surname}
                        onChange={e => setSurname(e.target.value)}
                        type={"text"}
                        className="form-control mt-2"
                        placeholder="Familiyangizni kiriting" />
                    <input
                        value={email}
                        onChange={e => setEmail(e.target.value)}
                        type={"email"}
                        className="form-control mt-2"
                        placeholder="Emailingizni kiriting" />
                    <input
                        value={password}
                        onChange={e => setPassword(e.target.value)}
                        type={"password"}
                        className="form-control mt-2"
                        placeholder="Parolingizni kiriting" />
                    <input
                        value={prePassword}
                        onChange={e => setPrePassword(e.target.value)}
                        type={"password"}
                        className="form-control mt-2"
                        placeholder="Parolini tasdiqlash uchun qayta kiriting" />
                    <button onClick={() => validate()} className="btn btn-primary mt-2">Tekshirish</button>
                </div>
            </div>
        </div>
    )
}
export default Last