import { useEffect, useState } from "react"
import axios from 'axios'

export const Cbu = () => {
    const [cubs, setCbus] = useState([])
    const [loading, setLoading] = useState(false)
    const getAll = async () => {
        try {
            const res = await axios.get('https://cbu.uz/oz/arkhiv-kursov-valyut/json/')
            setCbus(res.data)
            setLoading(true)
        } catch (err) {

        }
    }
    useEffect(() => {
        getAll()
    }, [])
    return (
        loading ? (
            <div className="container">
                <h3 className="text-center text-primary">O'zbekiston Markaziy valyutalari</h3>
                <div className="row row-100">
                    {cubs.map(item => (
                        <div className="w-25">
                            <div class="card p-0 m-1" style={{width: '100%'}}>
                                <div class="card-body">
                                    <h5 class="card-title">{item.Ccy}</h5>
                                    <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                                    <button type="button" class="btn btn-primary" data-mdb-ripple-init>Button</button>
                                </div>
                            </div>
                        </div>
                    ))}
                </div>
            </div>
        ) : (
            <div className="d-flex justify-content-center align-items-center text-align-center w-10" style={{ height: '85vh' }}>
                <div class="spinner-border" role="status">
                    <span class="visually-hidden">Loading...</span>
                </div>
            </div>
        )
    )
}