import { Link } from "react-router-dom";
import { toast } from "react-toastify";
export function First() {
    return (


        <div className="container">
            Birinchi sahifa
            <Link className="btn btn-primary" to={"/last"}>Ikkinchi sahifaga o'tish</Link>

            <div className="mt-3">
                <button onClick={() => toast.success("Mallades oka")} className="btn btn-success">Bosing oka</button>
                <button onClick={() => toast.dark("Qora bu ukalar")} className="btn btn-dark">Bosing oka</button>
                <button onClick={() => toast.info("Bu info")} className="btn btn-info">Bosing oka</button>
                <button onClick={() => toast.warning("Bu ogohlantiradi")} className="btn btn-warning">Bosing oka</button>
                <button onClick={() => toast("Bu toast")} className="btn btn-secondary">Bosing oka</button>
            </div>

            <div className="mt-3">
                <button className="btn btn-primary" onClick={() => alert("Bosdingiz")}>Bos</button>
                <button className="btn btn-primary" onDoubleClick={() => alert("Bosdingiz")}>2ta Bos</button>
                <input type="text" value={"qozilar armiyasi"} onCopy={(e) => console.log(e)} />
                <input type="text" onCut={(e) => console.log(e)} />
                <input type="text" onPaste={(e) => console.log(e)} />
                <button onMouseLeave={() => console.log("Hoverdan chiqdingiz")} onMouseMove={() => console.log("hover boldi")} className="btn btn-success">Hover</button>
                <input type={"text"} onChange={(e) => console.log(e.target.value)} />
            </div>
        </div>
    )
}