import React, { useState } from "react";
import "./TicTacToe.css";

const TicTacToe = () => {
    const [board, setBoard] = useState(Array(9).fill(null));
    const [xIsNext, setXIsNext] = useState(true);

    const handleClick = (index) => {
        if (board[index] || checkWinner()) return;
        const newBoard = [...board];
        newBoard[index] = xIsNext ? "X" : "O";
        setBoard(newBoard);
        setXIsNext(!xIsNext);
    };

    const checkWinner = () => {
        const lines = [
            [0, 1, 2], [3, 4, 5], [6, 7, 8],
            [0, 3, 6], [1, 4, 7], [2, 5, 8],
            [0, 4, 8], [2, 4, 6]
        ];
        for (let line of lines) {
            const [a, b, c] = line;
            if (board[a] && board[a] === board[b] && board[a] === board[c]) {
                return board[a];
            }
        }
        return null;
    };

    return (
        <div className="tic-tac-toe">
            {board.map((value, index) => (
                <button key={index} onClick={() => handleClick(index)}>{value}</button>
            ))}
            {checkWinner() && <p>Winner: {checkWinner()}</p>}
        </div>
    );
};

export default TicTacToe;
