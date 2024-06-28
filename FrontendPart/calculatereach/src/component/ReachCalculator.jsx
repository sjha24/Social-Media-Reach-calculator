import React, { useState } from 'react';
import axios from 'axios';

const ReachCalculator = () => {
    const [followers, setFollowers] = useState('');
    const [impressions, setImpressions] = useState(null);
    const [reach, setReach] = useState(null);
    const [error, setError] = useState(null);

    const handleSubmit = async (e) => {
        e.preventDefault();
        setError(null);

        try {
            const response = await axios.post('http://localhost:8080/api/calculate', {
                followers: parseInt(followers)
            });

            setImpressions(response.data.impressions);
            setReach(response.data.reach);
        } catch (error) {
            console.error('Error:', error);
            setError('There was an error with the request. Please try again.');
        }
    };

    return (
        <div>
            <h1>Instagram Reach Calculator</h1>
            <form onSubmit={handleSubmit}>
                <label htmlFor="followers">Number of Followers:</label>
                <input
                    type="number"
                    id="followers"
                    value={followers}
                    onChange={(e) => setFollowers(e.target.value)}
                    required
                />
                <button type="submit">Calculate</button>
            </form>
            {error && <p style={{ color: 'red' }}>{error}</p>}
            {impressions !== null && (
                <div id="results">
                    <p>Impressions: <span id="impressions">{impressions}</span></p>
                    <p>Reach: <span id="reach">{reach}</span></p>
                </div>
            )}
        </div>
    );
};

export default ReachCalculator;
